package com.ideax.project1.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.dao.NewsDAO;
import com.ideax.project1.pojo.News;

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
}
