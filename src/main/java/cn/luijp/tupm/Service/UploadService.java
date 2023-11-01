package cn.luijp.tupm.Service;

import cn.luijp.tupm.Pojo.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public FileUpload ImgUpload(MultipartFile FileName, int TargetId);
}
