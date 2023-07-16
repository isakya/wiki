package com.izumi.wiki.controller;

import com.izumi.wiki.req.EbookQueryReq;
import com.izumi.wiki.req.EbookSaveReq;
import com.izumi.wiki.resp.CommonResp;
import com.izumi.wiki.resp.EbookQueryResp;
import com.izumi.wiki.resp.PageResp;
import com.izumi.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/ebook")
public class EbookController {


    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }
}
