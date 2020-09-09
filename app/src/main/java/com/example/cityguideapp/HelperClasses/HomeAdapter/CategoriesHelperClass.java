package com.example.cityguideapp.HelperClasses.HomeAdapter;

public class CategoriesHelperClass {
    int image, relative_bg;
    String title;

    public CategoriesHelperClass(int image, String title, int relative_bg) {
        this.image = image;
        this.title = title;
        this.relative_bg = relative_bg;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getRelative_bg() {
        return relative_bg;
    }
}
