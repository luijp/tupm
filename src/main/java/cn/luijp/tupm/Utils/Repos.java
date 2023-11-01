package cn.luijp.tupm.Utils;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Repos<T>{
    private ReposCodeEnum Code;
    private String Message;
    private T Data;



    public static Repos success(){
        Repos resp = new Repos();
        resp.Code = ReposCodeEnum.SUCCESS;
        return resp;
    }

    public static Repos success(String Message){
        Repos resp = new Repos();
        resp.Code = ReposCodeEnum.SUCCESS;
        resp.setMessage(Message);
        return resp;
    }

    public static<T> Repos success(String Message,T Data){
        Repos resp = new Repos();
        resp.Code = ReposCodeEnum.SUCCESS;
        resp.setMessage(Message);
        resp.Data = Data;
        return resp;
    }

    public static<T> Repos success(T Data){
        Repos resp = new Repos();
        resp.Code = ReposCodeEnum.SUCCESS;
        resp.Data = Data;
        return resp;
    }

    public static Repos fail(){
        Repos resp = new Repos();
        resp.Code = ReposCodeEnum.FAIL;
        return resp;
    }

    public static Repos fail(ReposCodeEnum Code){
        Repos resp = new Repos();
        resp.Code = Code;
        return resp;
    }

    public static Repos fail(ReposCodeEnum Code, String Message){
        Repos resp = new Repos();
        resp.Code = Code;
        resp.Message = Message;
        return resp;
    }

    public static<T> Repos fail(ReposCodeEnum Code, String Message, T Data){
        Repos resp = new Repos();
        resp.Code = Code;
        resp.Message = Message;
        resp.Data = Data;
        return resp;
    }

}
