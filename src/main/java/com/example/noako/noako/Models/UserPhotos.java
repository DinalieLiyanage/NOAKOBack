package com.example.noako.noako.Models;

public class UserPhotos {
    private String folderName;
    private byte[] image;

  
    public String getFolderName() {
        return folderName;
    }

   
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

