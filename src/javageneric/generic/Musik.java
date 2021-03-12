/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javageneric.generic;

/**
 *
 * @author kmalif
 */
public class Musik {
    String path, fileName, fileSize, extensions;

    public Musik(String path, String fileName, String fileSize, String extensions) {
        this.path = path;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.extensions = extensions;
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getExtensions() {
        return extensions;
    }
    
    
    
}
