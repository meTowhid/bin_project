package com.nibri.binproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryData {
    public String title;
    @SerializedName("profile_image_url")
    public String profileImage;
    @SerializedName("items")
    public List<StoryItem> stories;

    public StoryData(String title, List<StoryItem> stories) {
        this.title = title;
        this.stories = stories;
    }

   public static class StoryItem {
        @SerializedName("img_url")
        public String imgUrl;
        public String mimeType;
        @SerializedName("thumb_url")
        public String thumbURL;
        public String title;
        public String description;
        @SerializedName("deep_link")
        public String deepLink;
        @SerializedName("web_url")
        public String webURL;
        @SerializedName("is_deep_link")
        public Boolean isDeepLink;

        public StoryItem(String imgUrl, String mimeType, String thumbURL, String title, String description, String deepLink, String webURL, Boolean isDeepLink) {
            this.imgUrl = imgUrl;
            this.mimeType = mimeType;
            this.thumbURL = thumbURL;
            this.title = title;
            this.description = description;
            this.deepLink = deepLink;
            this.webURL = webURL;
            this.isDeepLink = isDeepLink;
        }
    }
}
