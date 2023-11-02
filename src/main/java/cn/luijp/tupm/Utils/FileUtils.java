package cn.luijp.tupm.Utils;

import org.springframework.http.MediaType;

public class FileUtils {
    public static String GetFileExtendsion(String FileName) {
        Integer lastIndex = FileName.lastIndexOf(".");
        if(lastIndex != -1) {
            return FileName.substring(lastIndex + 1);
        }else {
            return FileName;
        }
    }

    public static MediaType GetFileTypeByExtension(String Extension){
        if(Extension.equalsIgnoreCase("jpg") || Extension.equalsIgnoreCase("jpeg")) {
            return MediaTypeAddtion.IMAGE_JPEG;
        }else if(Extension.equalsIgnoreCase("png")){
            return MediaTypeAddtion.IMAGE_PNG;
        } else if (Extension.equalsIgnoreCase("gif") ) {
            return  MediaTypeAddtion.IMAGE_GIF;
        }
        else if (Extension.equalsIgnoreCase("webp") ) {
            return  MediaTypeAddtion.IMAGE_WEBP;
        }

        return MediaTypeAddtion.ALL;

    }
}
