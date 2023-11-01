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



    public static Repos<Object> success(){
        Repos<Object> resp = new Repos<>();
        resp.Code = ReposCodeEnum.SUCCESS;
        return resp;
    }

    public static Repos<Object> success(String Message){
        Repos<Object> resp = new Repos<>();
        resp.Code = ReposCodeEnum.SUCCESS;
        resp.setMessage(Message);
        return resp;
    }

    public static<T> Repos<T> success(String Message,T Data){
        Repos<T> resp = new Repos<>();
        resp.Code = ReposCodeEnum.SUCCESS;
        resp.setMessage(Message);
        resp.Data = Data;
        return resp;
    }

    public static<T> Repos<T> success(T Data){
        Repos<T> resp = new Repos<>();
        resp.Code = ReposCodeEnum.SUCCESS;
        resp.Data = Data;
        return resp;
    }

    public static Repos<Object> fail(){
        Repos<Object> resp = new Repos<>();
        resp.Code = ReposCodeEnum.FAIL;
        return resp;
    }

    public static Repos<Object> fail(ReposCodeEnum Code){
        Repos<Object> resp = new Repos<>();
        resp.Code = Code;
        return resp;
    }

    public static Repos<Object> fail(ReposCodeEnum Code, String Message){
        Repos<Object> resp = new Repos<>();
        resp.Code = Code;
        resp.Message = Message;
        return resp;
    }

    public static<T> Repos<T> fail(ReposCodeEnum Code, String Message, T Data){
        Repos<T> resp = new Repos<>();
        resp.Code = Code;
        resp.Message = Message;
        resp.Data = Data;
        return resp;
    }

}
