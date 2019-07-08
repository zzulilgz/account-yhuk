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

    private Integer id;

    private String label;

    private List<MenuTreeBo> children = new ArrayList<>();

}
