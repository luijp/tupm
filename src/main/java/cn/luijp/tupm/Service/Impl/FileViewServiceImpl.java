package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import cn.luijp.tupm.Exception.FileViewException;
import cn.luijp.tupm.Pojo.FileUpload;
import cn.luijp.tupm.Pojo.Mapper.FileUploadMapper;
import cn.luijp.tupm.Service.FileViewService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

@Service
public class FileViewServiceImpl implements FileViewService {
    private FileUploadMapper fileUploadMapper;

    @Autowired
    public FileViewServiceImpl(FileUploadMapper fileUploadMapper) {
        this.fileUploadMapper = fileUploadMapper;
    }

    @Override
    public ViewFileClass  ViewFile(int TargetId) throws MalformedURLException,FileViewException {
        QueryWrapper<FileUpload> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", TargetId);
        FileUpload fileUpload = fileUploadMapper.selectOne(queryWrapper);
        if(fileUpload == null){
            throw new FileViewException(ReposCodeEnum.FILE_NOT_FOUND);
        }
        Path FilePath = Paths.get(fileUpload.getStoragefolder()).resolve(fileUpload.getStoragename());
        Resource resource = new UrlResource(FilePath.toUri());

        if(resource.exists() && resource.isReadable()){
            ViewFileClass viewFileClass = new ViewFileClass();
            viewFileClass.setFileUpload(fileUpload);
            viewFileClass.setResource(resource);
            return viewFileClass;
        }else{
            throw new FileViewException(ReposCodeEnum.FILE_UPLOADED_BROKEN);
        }

    }
}

