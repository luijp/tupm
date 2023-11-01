package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Exception.FileUploadException;
import cn.luijp.tupm.Pojo.FileUpload;
import cn.luijp.tupm.Pojo.Mapper.FileUploadMapper;
import cn.luijp.tupm.Pojo.StorageConfig;
import cn.luijp.tupm.Service.FileUploadService;
import cn.luijp.tupm.Service.SiteConfigService;
import cn.luijp.tupm.Service.StorageConfigService;
import cn.luijp.tupm.Service.UploadService;
import cn.luijp.tupm.Utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

@Service
public class UploadServiceImpl implements UploadService {
    private final FileUploadService s3Uploader;
    private final FileUploadService localUploader;

    @Autowired
    SiteConfigService siteConfigService;

    @Autowired
    StorageConfigService storageConfigService;

    @Autowired
    FileUploadMapper fileUploadMapper;

    @Autowired
    public UploadServiceImpl(@Qualifier("S3") FileUploadService s3Uploader,
                       @Qualifier("Local") FileUploadService localUploader){
        this.s3Uploader = s3Uploader;
        this.localUploader = localUploader;

    }

    public FileUpload ImgUpload(MultipartFile FileName, int TargetId) {
        StorageConfig storageConfig = storageConfigService.GetStorageConfigById(TargetId);
        if(storageConfig.getTarget() == 0){
            //本地
            return Upload2Local(FileName, storageConfig);
        }else{
            return Upload2S3(FileName, storageConfig);
        }
    }

    private FileUpload Upload2Local(MultipartFile FileName, StorageConfig storageConfig) {
        try{
            Long NowTime = System.currentTimeMillis();
            String StorageFolder = storageConfig.getLocalfilepath();
            String StorageName = NowTime + UUID.randomUUID();
            String OriginName = FileName.getOriginalFilename();
            File DestFile = new File(StorageFolder,StorageName);
            FileName.transferTo(DestFile);

            FileUpload fileUpload = new FileUpload();
            fileUpload.setOriginname(OriginName);
            fileUpload.setStoragename(StorageName);
            fileUpload.setStoragefolder(StorageFolder);
            fileUpload.setCreatetime(new Timestamp(NowTime));
            fileUploadMapper.insert(fileUpload);
            return fileUpload;
        } catch (IOException e) {
            throw new FileUploadException("FILE UPLOAD FAILED :" + Arrays.toString(e.getStackTrace()));
        }


    }
    private FileUpload Upload2S3(MultipartFile FileName, StorageConfig storageConfig) throws FileUploadException {
        throw new FileUploadException("NOT FINISHED CODING....");
    }
}
