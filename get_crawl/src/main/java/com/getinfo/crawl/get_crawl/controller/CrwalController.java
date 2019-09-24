package com.getinfo.crawl.get_crawl.controller;

import com.getinfo.crawl.get_crawl.vo.R;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawl")
public class CrwalController {

    @PostMapping("/crawlCode")
    public ResponseEntity<R> crawlCode(@RequestParam("category1st")String category1st) {

return ResponseEntity.ok().build();
    }



}
