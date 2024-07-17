package org.lycoding.controller;

import org.lycoding.pojo.Notice;
import org.lycoding.pojo.Result;
import org.lycoding.service.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@CrossOrigin
public class NoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;
//    发布通知
    @PostMapping("/info")
    public Result addNotice(Notice notice){
        System.out.println("notice = " + notice);
        noticeService.addNotice(notice);
        return Result.success("发布成功","");
    }
//    获取所有公开的通知
    @GetMapping("/info")
    public Result<List> list(){
        List<Notice> list = noticeService.list();
        return Result.success("",list);
    }
//    删除
    @DeleteMapping("delete/{id}")
    public Result<String> deleteNotice(@PathVariable Integer id){
        noticeService.deleteNotice(id);
        return Result.success("删除成功",null);
    }

}
