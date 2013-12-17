package com.ideax.project1.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.common.Result;
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

	public List<News> getNewsList(int page, int pagesize) {
		try {
			List<News> list = newsDAO.getNewsList((NewsQuery) new NewsQuery().orderbySendTime(false).setPage(1)
					.setPageSize(6));
			return list;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public List<News> getNewsListByViewcount(int pdId, int page, int pagesize) {
		try {
			NewsQuery query = new NewsQuery().orderbyViewCount(false);
			if (pdId > 0)
				query.setPdId(pdId);
			query.setPage(1).setPageSize(6);

			List<News> list = newsDAO.getNewsList(query);
			return list;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public List<News> getLanmuNewsList(int lmid, int page, int pagesize) {
		try {
			List<News> list = newsDAO.getNewsList((NewsQuery) new NewsQuery().setLmId(lmid).orderbySendTime(false)
					.setPage(1).setPageSize(6));
			return list;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public Result<News> getLanmuNewsListWithPage(int pdId, int lmid, int page, int pagesize) {
		NewsQuery query = new NewsQuery();
		if (pdId > 0)
			query.setPdId(pdId);
		if (lmid > 0)
			query.setLmId(lmid);
		query.orderbyId(false);
		query.setPage(page).setPageSize(pagesize);
		Result<News> rst = newsDAO.getNewsListWithPage(query);
		return rst;
	}

	public Result<News> getPageLanmuNewsList(int lmid, int page, int pagesize) {
		Result<News> list = newsDAO.getNewsListWithPage((NewsQuery) new NewsQuery().setLmId(lmid)
				.orderbySendTime(false).setPage(1).setPageSize(6));
		return list;
	}

	public void updateNewsById(News update) {
		try {
			newsDAO.updateNews(update);
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}

	}

	public int insertNews(News update) {
		try {
			return newsDAO.addNews(update);
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}

	}

	public int deleteById(int id) {
		try {
			return newsDAO.deleteByKey(id);
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}
}
