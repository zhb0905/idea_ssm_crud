package org.zhb.ssm.crud.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhb
 * @create 2022-03-17 3:22
 */
@Data
public class Msg {
    private int code;
    private String msg;
    private Map<String,Object> data = new HashMap<>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理失败");
        return result;
    }

    //链式编程 返回一个this对象，就是返回本身，
    public Msg add(String key,Object value) {
        this.getData().put(key, value);
        return this;
    }
}
