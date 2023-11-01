package cn.luijp.tupm.Utils;

public class UUID {
    public static String randomUUID(){
        java.util.UUID uuid = java.util.UUID.randomUUID();
        return uuid.toString();
    }
}
