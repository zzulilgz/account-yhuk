package com.yhuk.account.object.request;

import lombok.Data;

import java.util.Date;

@Data
public class ListByPageQo {

    private Date startTime;

    private Date endTime;

    private Integer pageNo=0;

    private Integer pageSize=10;

    private String[] ascs;

    private String[] descs;

}
