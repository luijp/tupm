package cn.luijp.tupm.Pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@TableName("StorageConfig")
public class StorageConfig {
    @TableId
    @TableField("id")
    private Integer id;
    @TableField("target")
    private Integer target;
    @TableField("localfilepath")
    private String localfilepath;
    @TableField("s3Ak")
    private String s3Ak;
    @TableField("s3Sk")
    private String s3Sk;
    @TableField("s3Region")
    private String s3Region;
    @TableField("s3Bucketname")
    private String s3Bucketname;
    @TableField("weight")
    private Integer weight;


}
