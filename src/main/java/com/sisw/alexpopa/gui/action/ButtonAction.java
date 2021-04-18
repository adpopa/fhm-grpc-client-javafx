package com.sisw.alexpopa.gui.action;

import com.sisw.alexpopa.clientgrpc.GrpcChannelFactory;
import com.sisw.alexpopa.grpc.DirectoryMonitorService.*;
import com.sisw.alexpopa.grpc.MonitorServiceGrpc;
import com.sisw.alexpopa.grpc.MonitorServiceGrpc.*;
import com.sisw.alexpopa.model.FileEntry;
import io.grpc.StatusRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Alex Daniel Popa
 */
public class ButtonAction {

    private static final Logger LOGGER = LogManager.getLogger(ButtonAction.class);

    private static MonitorServiceBlockingStub blockingStub = null;

    public static void startMonitor() {
        if(blockingStub == null) {
            conn();
        }

        StartMonitorRequest request = StartMonitorRequest.newBuilder().setMsgStartMonitorRequest("./MonitoredFolder").build();

        StartMonitorResponse response = blockingStub.startMonitor(request);

        LOGGER.info(response.getMsgStartMonitorResponse());

    }

    public static void stopMonitor() {

        StopMonitorRequest request = StopMonitorRequest.newBuilder().setMsgStopMonitorRequest("Stop the Monitor").build();

        StopMonitorResponse response = blockingStub.stopMonitor(request);

        LOGGER.info(response.getMsgStopMonitorResponse());

    }

    public static List<FileEntry> recorder() {
        RecorderRequest request = RecorderRequest.newBuilder().setMsgStartRecordingRequest("record").build();

        List<FileEntry> fileEntryList = new ArrayList<FileEntry>();
        try {
            Iterator<RecorderResponse> response = blockingStub.recorder(request);

            while (response.hasNext()) {
//                LOGGER.info(response.next().toString());
                RecorderResponse nextResponse = response.next();
                FileEntry fileEntry = new FileEntry();
                fileEntry.setId(nextResponse.getEntryId());
                fileEntry.setFilename(nextResponse.getFilename());
                fileEntry.setEventKind(nextResponse.getEventKind());
                fileEntry.setOperationDateTme(nextResponse.getOperationDateTme());

                if(nextResponse.getFileDetailsId() != 0L) {
                    fileEntry.setFileDetailsId(nextResponse.getFileDetailsId());
                    fileEntry.setExtension(nextResponse.getExtension());
                    fileEntry.setSize(nextResponse.getSize());
                    fileEntry.setCreationDate(nextResponse.getCreationDate());
                    fileEntry.setModificationDate(nextResponse.getModificationDate());
                }

                fileEntryList.add(fileEntry);
            }

        } catch (StatusRuntimeException e) {
            LOGGER.error("RPC failed: {0}" + e.getStatus());
        }
        return fileEntryList;
    }


    public static void stopRecorder() {
        StopRecorderRequest request = StopRecorderRequest.newBuilder().setMsgStopRecordingRequest("Stop the Recorder").build();

        StopRecorderResponse response = blockingStub.stopRecorder(request);

        LOGGER.info(response.getMsgStopRecordingResponse());

    }

    private static void conn() {
        try {
            GrpcChannelFactory grpcMonitorClient = new GrpcChannelFactory("localhost",9090);
            blockingStub = MonitorServiceGrpc.newBlockingStub(grpcMonitorClient.getChannel());
        } catch (InterruptedException e) {
            LOGGER.error(e.fillInStackTrace().toString());
        }
    }

}
