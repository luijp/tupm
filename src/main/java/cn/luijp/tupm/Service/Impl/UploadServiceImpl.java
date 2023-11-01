package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Service.FileUploadService;
import cn.luijp.tupm.Service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    private final FileUploadService s3Uploader;
    private final FileUploadService localUploader;


    @Autowired
    public UploadServiceImpl(@Qualifier("S3") FileUploadService s3Uploader,
                       @Qualifier("Local") FileUploadService localUploader){
        this.s3Uploader = s3Uploader;
        this.localUploader = localUploader;

    }
}
