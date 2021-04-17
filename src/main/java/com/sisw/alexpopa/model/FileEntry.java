package com.sisw.alexpopa.model;

import java.time.Instant;

/**
 * @author Alex Daniel Popa
 */
public class FileEntry {

    private Long id;
    private String filename;
    private String eventKind;
    private String operationDateTme;

    private Long fileDetailsId = 0L;
    private String extension = "None";
    private Long size = 0L;
    private String creationDate = "None";
    private String modificationDate = "None";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getEventKind() {
        return eventKind;
    }

    public void setEventKind(String eventKind) {
        this.eventKind = eventKind;
    }

    public String getOperationDateTme() {
        return operationDateTme;
    }

    public void setOperationDateTme(String operationDateTme) {
        this.operationDateTme = operationDateTme;
    }

    public Long getFileDetailsId() {
        return fileDetailsId;
    }

    public void setFileDetailsId(Long fileDetailsId) {
        this.fileDetailsId = fileDetailsId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public FileEntry() {
    }
}
