package com.yhuk.account.object.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 树形菜单
 * @Author gaozhi.liu
 * @Date 2019/7/8 10:51
 * @Version 1.0
 **/
@Data
public class MenuTreeBo {

    private String id;

    private String label;
    //对于menu来说是路由地址，对于operation来说是访问地址
    private String path;

    private List<MenuTreeBo> children = new ArrayList<>();

}
