package com.meipan.library.api.model;

import java.io.Serializable;

/**
 * Created by vaio on 2016/1/2.
 */
public class LocalFileDirectoryEntity implements Serializable{
    private String filePath;
    private String fileName;
    private String imagePath;
    private String imageName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
