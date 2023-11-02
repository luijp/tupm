package cn.luijp.tupm.Utils;

import org.springframework.http.MediaType;

public class MediaTypeAddtion extends MediaType {
    public MediaTypeAddtion(String type) {
        super(type);
    }

    public static final MediaType IMAGE_WEBP = new MediaType("image", "webp");;
    public static final String IMAGE_WEBP_VALUE = "image/webp";
}
