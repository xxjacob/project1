package com.ideax.project1.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.dao.NewsDAO;
import com.ideax.project1.pojo.News;
import com.ideax.project1.query.NewsQuery;

@Service
public class NewsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NewsDAO newsDAO;

    public News getNewsById(int id) {
        try {
            News list = newsDAO.getNewsbyKey(id);
            return list;
        } catch (SQLException e) {
            logger.error("", e);
            throw new IllegalException(EC.EC_DB);
        }
    }

    public List<News> getNewsList(int id, int page, int pagesize) {
        try {
            List<News> list = newsDAO.getNewsList((NewsQuery) new NewsQuery().orderbySendTime(false).setPage(1)
                    .setPageSize(6));
            return list;
        } catch (SQLException e) {
            logger.error("", e);
            throw new IllegalException(EC.EC_DB);
        }
    }

    public void updateNewsById(News update) {
        try {
            newsDAO.updateNews(update);
        } catch (SQLException e) {
            logger.error("", e);
            throw new IllegalException(EC.EC_DB);
        }

    }
}
