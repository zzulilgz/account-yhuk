package com.yhuk.account.object.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/5/5 11:42
 * @Version 1.0
 **/
@Data
public class ResourceBo {

    private String name;
    private String path;

    public ResourceBo() {
    }

    public ResourceBo(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
