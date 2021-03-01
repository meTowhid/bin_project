package com.nibri.binproject.model;

import java.util.List;

public class StoryData {
    public String title;
    public List<String> images;

    public StoryData(String title, List<String> images) {
        this.title = title;
        this.images = images;
    }
}
