package org.lycoding.service.impl;

import org.lycoding.mapper.NoticeMapper;
import org.lycoding.pojo.Notice;
import org.lycoding.service.NoticeService;
import org.lycoding.utils.currentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public void addNotice(Notice notice) {
        notice.setPublishUser(currentUserUtil.getUserName());
        noticeMapper.addNotice(notice);
    }

    @Override
    public List<Notice> list() {
       return noticeMapper.list();
    }

    @Override
    public void deleteNotice(Integer id) {
        noticeMapper.deleteNotice(id);
    }
}
