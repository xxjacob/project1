package com.ideax.project1.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideax.common.KVStore;
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
	@Autowired
	KVStore kvStore;

	final String PD_INFO_ALL_KEY = "pd_info_all";
	final String LANMU_KEY_PREFIX = "lanmu_";
	final String PINDAO_KEY_PREFIX = "pindao_";

	@SuppressWarnings("unchecked")
	public Map<Pindao, List<Lanmu>> getPindaoMap() {
		Map<Pindao, List<Lanmu>> allinfo = (Map<Pindao, List<Lanmu>>) kvStore.get(PD_INFO_ALL_KEY);
		if (allinfo == null || allinfo.size() == 0)
			try {
				allinfo = buildAllInfo();
			} catch (SQLException e) {
				logger.error("DB", e);
				throw new IllegalException(EC.EC_DB);
			}
		return allinfo;
	}

	private Map<Pindao, List<Lanmu>> buildAllInfo() throws SQLException {
		Map<Pindao, List<Lanmu>> allinfo = new LinkedHashMap<Pindao, List<Lanmu>>();
		List<Pindao> pdlist = pindaoDAO.getPindaoList(new PindaoQuery().orderbyOrderNum(true));
		List<Lanmu> lmlist = lanmuDAO.getLanmuList(new LanmuQuery().orderbyOrderNum(true));
		for (Pindao pd : pdlist) {
			kvStore.put(PINDAO_KEY_PREFIX + pd.getId(), pd);
			List<Lanmu> list = new ArrayList<Lanmu>();
			for (Lanmu lm : lmlist) {
				if (lm.getPdId().equals(pd.getId())) {
					list.add(lm);
					kvStore.put(LANMU_KEY_PREFIX + lm.getId(), lm);
				}
			}
			allinfo.put(pd, list);
		}
		kvStore.put(PD_INFO_ALL_KEY, allinfo);
		return allinfo;
	}

	@SuppressWarnings("unchecked")
	public List<Lanmu> getLanmusByPdid(int pdid) {
		Map<Pindao, List<Lanmu>> allinfo = (Map<Pindao, List<Lanmu>>) kvStore.get(PD_INFO_ALL_KEY);
		if (allinfo == null || allinfo.size() == 0)
			try {
				allinfo = buildAllInfo();
			} catch (SQLException e) {
				logger.error("DB", e);
				throw new IllegalException(EC.EC_DB);
			}
		for (Entry<Pindao, List<Lanmu>> a : allinfo.entrySet()) {
			if (a.getKey().getId() == pdid) {
				return a.getValue();
			}
		}
		return null;
	}

	public Lanmu getLanmuByKey(int id) {
		String key = LANMU_KEY_PREFIX + id;
		Lanmu lm = (Lanmu) kvStore.get(key);
		if (lm == null)
			try {
				lm = lanmuDAO.getLanmubyKey(id);
				if (lm != null)
					kvStore.put(key, lm);
			} catch (SQLException e) {
				logger.error("DB", e);
				throw new IllegalException(EC.EC_DB);
			}
		return lm;

	}

	public Pindao getPindaoByKey(int id) {
		String key = PINDAO_KEY_PREFIX + id;
		Pindao pd = (Pindao) kvStore.get(key);
		if (pd == null)
			try {
				pd = pindaoDAO.getPindaobyKey(id);
				if (pd != null)
					kvStore.put(key, pd);
			} catch (SQLException e) {
				logger.error("DB", e);
				throw new IllegalException(EC.EC_DB);
			}
		return pd;

	}

	public Map<Integer, Pindao> getPindaoKeyMap() {
		Map<Pindao, List<Lanmu>> allinfo = (Map<Pindao, List<Lanmu>>) kvStore.get(PD_INFO_ALL_KEY);
		if (allinfo == null || allinfo.size() == 0)
			try {
				allinfo = buildAllInfo();
			} catch (SQLException e) {
				logger.error("DB", e);
				throw new IllegalException(EC.EC_DB);
			}
		Map<Integer, Pindao> pdidMap = new HashMap<Integer, Pindao>();
		for (Entry<Pindao, List<Lanmu>> a : allinfo.entrySet()) {
			pdidMap.put(a.getKey().getId(), a.getKey());
		}
		return pdidMap;

	}
}
