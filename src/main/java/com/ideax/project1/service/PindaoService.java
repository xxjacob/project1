package com.ideax.project1.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.dao.LanmuDAO;
import com.ideax.project1.dao.PindaoDAO;
import com.ideax.project1.pojo.Lanmu;
import com.ideax.project1.pojo.Pindao;
import com.ideax.project1.query.LanmuQuery;
import com.ideax.project1.query.PindaoQuery;

@Service
public class PindaoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PindaoDAO pindaoDAO;
	@Autowired
	LanmuDAO lanmuDAO;

	Map<Pindao, List<Lanmu>> allinfo = new LinkedHashMap<Pindao, List<Lanmu>>();

	public Map<Pindao, List<Lanmu>> getPindaoMap() {
		if (allinfo == null || allinfo.size() == 0)
			try {
				buildAllInfo();
			} catch (SQLException e) {
				logger.error("DB", e);
				throw new IllegalException(EC.EC_DB);
			}
		return allinfo;
	}

	public void buildAllInfo() throws SQLException {
		List<Pindao> pdlist = pindaoDAO.getPindaoList(new PindaoQuery().orderbyOrderNum(true));
		List<Lanmu> lmlist = lanmuDAO.getLanmuList(new LanmuQuery().orderbyOrderNum(true));
		for (Pindao pd : pdlist) {
			logger.debug("#########"+pd.getName());
			List<Lanmu> list = new ArrayList<Lanmu>();
			for (Lanmu lm : lmlist) {
				if (lm.getPdId() == pd.getId()){
					list.add(lm);
				}
			}
			allinfo.put(pd, list);
		}
	}
}
