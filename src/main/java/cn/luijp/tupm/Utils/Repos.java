package cn.luijp.tupm.Utils;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Repos<T>{
    private Integer Code;
    private String Message;
    private T Data;



    public static Repos<Object> success(){
        Repos<Object> resp = new Repos<>();
        resp.setCode(ReposCodeEnum.SUCCESS.getCode());
        resp.setMessage(ReposCodeEnum.SUCCESS.getMessage());
        return resp;
    }


    public static<T> Repos<T> success(T Data){
        Repos<T> resp = new Repos<>();
        resp.setCode(ReposCodeEnum.SUCCESS.getCode());
        resp.setData(Data);
        return resp;
    }

    public static Repos<Object> fail(){
        Repos<Object> resp = new Repos<>();
        resp.setCode(ReposCodeEnum.FAIL.getCode());
        resp.setMessage(ReposCodeEnum.FAIL.getMessage());
        return resp;
    }

    public static Repos<Object> fail(ReposCodeEnum Code){
        Repos<Object> resp = new Repos<>();
        resp.setCode(Code.getCode());
        resp.setMessage(Code.getMessage());
        return resp;
    }

    public static Repos<Object> fail(ReposCodeEnum Code, String Message){
        Repos<Object> resp = new Repos<>();
        resp.setCode(Code.getCode());
        resp.setMessage(Message);
        return resp;
    }

    public static<T> Repos<T> fail(ReposCodeEnum Code, String Message, T Data){
        Repos<T> resp = new Repos<>();
        resp.setCode(Code.getCode());
        resp.setMessage(Message);
        resp.setData(Data);
        return resp;
    }

    public static<T> Repos<T> fail(ReposCodeEnum Code, T Data){
        Repos<T> resp = new Repos<>();
        resp.setCode(Code.getCode());
        resp.setData(Data);
        return resp;
    }

}
