package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import cn.luijp.tupm.Exception.FileUploadException;
import cn.luijp.tupm.Pojo.FileUpload;
import cn.luijp.tupm.Pojo.Mapper.FileUploadMapper;
import cn.luijp.tupm.Pojo.Mapper.StorageConfigMapper;
import cn.luijp.tupm.Pojo.StorageConfig;
import cn.luijp.tupm.Service.SiteConfigService;
import cn.luijp.tupm.Service.StorageConfigService;
import cn.luijp.tupm.Service.UploadService;
import cn.luijp.tupm.Utils.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {


    SiteConfigService siteConfigService;

    StorageConfigService storageConfigService;

    FileUploadMapper fileUploadMapper;

    StorageConfigMapper storageConfigMapper;

    @Autowired
    public UploadServiceImpl(SiteConfigService siteConfigService,
                             StorageConfigService storageConfigService,
                             FileUploadMapper fileUploadMapper,
                             StorageConfigMapper storageConfigMapper){
        this.siteConfigService = siteConfigService;
        this.storageConfigService = storageConfigService;
        this.fileUploadMapper = fileUploadMapper;
        this.storageConfigMapper = storageConfigMapper;


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
            long NowTime = System.currentTimeMillis();
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
            throw new FileUploadException(ReposCodeEnum.FILE_UPLOAD_FAILED);
        }


    }
    private FileUpload Upload2S3(MultipartFile FileName, StorageConfig storageConfig) throws FileUploadException {
        throw new FileUploadException(ReposCodeEnum.FAIL);
    }

}
