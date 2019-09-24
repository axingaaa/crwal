package com.getinfo.crawl.get_crawl.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class R {
    Object data;
    Date    date;
    int status;
}
