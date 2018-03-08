package com.example.marco.marcabrowser;

import java.io.Serializable;

public class Marca implements Serializable {

    private static final long serialVersionUID = -8392595923172582912L;

    private String mTitle;
    private String mAuthor;
    private String mDescription;
    private String mImage;

    public Marca(String mTitle, String mAuthor, String mDescription, String mImage) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mDescription = mDescription;
        this.mImage = mImage;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getImage() {
        return mImage;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mImage='" + mImage + '\'' +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }
}
