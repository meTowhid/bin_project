package com.nibri.binproject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nibri.binproject.model.StoryData;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class DummyData {

    private static final Gson gson = new Gson();
    static String jsonString = "[" +
            "{\n" +
            "  \"title\": \"Empty-Fridge-Grocery\",\n" +
            "  \"profile_image_url\": \"https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg\",\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"img_url\": \"https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg\",\n" +
            "      \"mime_type\": \"image\",\n" +
            "      \"thumb_url\": \"https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg\",\n" +
            "      \"title\": \"Pizza Hut\",\n" +
            "      \"description\": \"৳৳৳ · Home cook · Fast food · Burger · Home cook · Fast food · Burger\",\n" +
            "      \"deep_link\": \"https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg\",\n" +
            "      \"web_url\": \"\",\n" +
            "      \"is_deep_link\": true\n" +
            "    }\n" +
            "  ]\n" +
            "}," +
            "{\n" +
            "  \"title\": \"Empty-Fridge-Grocery\",\n" +
            "  \"profile_image_url\": \"https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg\",\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"img_url\": \"https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg\",\n" +
            "      \"mime_type\": \"image\",\n" +
            "      \"thumb_url\": \"https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg\",\n" +
            "      \"title\": \"Pizza Hut\",\n" +
            "      \"description\": \"৳৳৳ · Home cook · Fast food · Burger · Home cook · Fast food · Burger\",\n" +
            "      \"deep_link\": \"https://www.shohoz.com/?cuisine_id=101\",\n" +
            "      \"web_url\": \"\",\n" +
            "      \"is_deep_link\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_url\": \"https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg\",\n" +
            "      \"mime_type\": \"image\",\n" +
            "      \"thumb_url\": \"https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg\",\n" +
            "      \"title\": \"Pizza Hut\",\n" +
            "      \"description\": \"৳৳৳ · Home cook · Fast food · Burger · Home cook · Fast food · Burger\",\n" +
            "      \"deep_link\": \"https://www.shohoz.com/?cuisine_id=101\",\n" +
            "      \"web_url\": \"\",\n" +
            "      \"is_deep_link\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_url\": \"https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg\",\n" +
            "      \"mime_type\": \"image\",\n" +
            "      \"thumb_url\": \"https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg\",\n" +
            "      \"title\": \"Pizza Hut\",\n" +
            "      \"description\": \"৳৳৳ · Home cook · Fast food · Burger · Home cook · Fast food · Burger\",\n" +
            "      \"deep_link\": \"https://www.shohoz.com/?cuisine_id=101\",\n" +
            "      \"web_url\": \"\",\n" +
            "      \"is_deep_link\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_url\": \"https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg\",\n" +
            "      \"mime_type\": \"image\",\n" +
            "      \"thumb_url\": \"https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg\",\n" +
            "      \"title\": \"Pizza Hut\",\n" +
            "      \"description\": \"৳৳৳ · Home cook · Fast food · Burger · Home cook · Fast food · Burger\",\n" +
            "      \"deep_link\": \"https://www.shohoz.com/?cuisine_id=101\",\n" +
            "      \"web_url\": \"\",\n" +
            "      \"is_deep_link\": true\n" +
            "    }\n" +
            "  ]\n" +
            "}," +
            "{\n" +
            "  \"title\": \"Empty-Fridge-Grocery\",\n" +
            "  \"profile_image_url\": \"https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg\",\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"img_url\": \"https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg\",\n" +
            "      \"mime_type\": \"image\",\n" +
            "      \"thumb_url\": \"https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg\",\n" +
            "      \"title\": \"Pizza Hut\",\n" +
            "      \"description\": \"৳৳৳ · Home cook · Fast food · Burger · Home cook · Fast food · Burger\",\n" +
            "      \"deep_link\": \"https://www.shohoz.com/?cuisine_id=101\",\n" +
            "      \"web_url\": \"\",\n" +
            "      \"is_deep_link\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_url\": \"https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg\",\n" +
            "      \"mime_type\": \"image\",\n" +
            "      \"thumb_url\": \"https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg\",\n" +
            "      \"title\": \"Pizza Hut\",\n" +
            "      \"description\": \"৳৳৳ · Home cook · Fast food · Burger · Home cook · Fast food · Burger\",\n" +
            "      \"deep_link\": \"https://www.shohoz.com/?cuisine_id=101\",\n" +
            "      \"web_url\": \"\",\n" +
            "      \"is_deep_link\": true\n" +
            "    }\n" +
            "  ]\n" +
            "}" +
            "]";

    public static List<StoryData> storyDataFromJson() {
        Type listType = new TypeToken<List<StoryData>>() {
        }.getType();
        return gson.fromJson(jsonString, listType);
    }

    /*public static List<StoryData> storyData() {
        String[] imageUrls = new String[]{
                "https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/10/10/15/28/butterfly-2837589_960_720.jpg"
        };

        List<String> threeImages = new ArrayList<>();
        threeImages.add(imageUrls[0]);
        threeImages.add(imageUrls[1]);
        threeImages.add(imageUrls[2]);
        List<String> twoImages = new ArrayList<>();
        twoImages.add(imageUrls[3]);
        twoImages.add(imageUrls[4]);
        List<String> oneImages = new ArrayList<>();
        oneImages.add(imageUrls[0]);

        List<StoryData> storyData = new ArrayList<>();
        storyData.add(new StoryData("Something Special About - Food", threeImages));
        storyData.add(new StoryData("Something Special About - Bus", twoImages));
        storyData.add(new StoryData("Something Special About - Lunch", oneImages));
        storyData.add(new StoryData("Something Special About - Bus", threeImages));
        storyData.add(new StoryData("Something Special About - Bus", twoImages));

        return storyData;
    }*/
}
