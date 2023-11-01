package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("S3")
public class FileUploadServiceS3Impl implements FileUploadService {
    @Override
    public void FileUpload(MultipartFile UploadFile) {

    }
}
