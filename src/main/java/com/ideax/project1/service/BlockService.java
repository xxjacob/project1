package com.ideax.project1.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.common.Const;
import com.ideax.project1.dao.BlockDAO;
import com.ideax.project1.dao.LanmuDAO;
import com.ideax.project1.pojo.Block;
import com.ideax.project1.query.BlockQuery;

@Service
public class BlockService implements InitializingBean {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BlockDAO blockDAO;
	@Autowired
	LanmuDAO lanmuDAO;
	@Autowired
	private VelocityConfigurer velocityConfig;

	@Autowired
	PindaoService pindaoService;

	@Value("${img.upload.path}")
	String staticPath;

	public List<Block> getBlockByBlockGroup(int groupid) {
		try {
			List<Block> list = blockDAO.getBlockList(new BlockQuery().setBlockGroup(groupid));
			if (list == null)
				return Collections.emptyList();
			return list;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public List<Block> getAllBlocks() {
		try {
			List<Block> list = blockDAO.getBlockList(new BlockQuery());
			if (list == null)
				return Collections.emptyList();
			return list;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public int updateBlock(Block block) {
		try {
			return blockDAO.updateBlock(block);
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public Map<Integer, List<Block>> getAllBlocksByPageid(int pageId) {
		try {
			Map<Integer, List<Block>> blocks = new HashMap<Integer, List<Block>>();
			List<Block> pagelist = blockDAO.getBlockList(new BlockQuery().setPageId(pageId).orderbyOrderNum(true));
			for (Block block : pagelist) {
				int bgid = block.getBlockGroup();
				List<Block> list = blocks.get(bgid);
				if (list == null) {
					list = new ArrayList<Block>();
					blocks.put(bgid, list);
				}
				list.add(block);
			}
			return blocks;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public List<Block> getAllBlocksByPageidAndPdid(int pageId, int pdid) {
		try {
			List<Block> pagelist = blockDAO.getBlockList(new BlockQuery().setPageId(pageId).setPindaoId(pdid)
					.orderbyOrderNum(true));
			return pagelist;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public void generateHtml(int pageId) {
		try {
			Map<Integer, List<Block>> blocks = getAllBlocksByPageid(pageId);

			VelocityEngine engine = velocityConfig.getVelocityEngine();
			Template tpl = engine.getTemplate("index.vm", "UTF-8");
			System.out.println(tpl.getName());
			tpl.setEncoding("UTF-8");
			VelocityContext ctx = new VelocityContext();
			ctx.put("blocks", blocks);
			ctx.put("pdmap", pindaoService.getPindaoMap());
			// BufferedWriter writer = new BufferedWriter(new
			// FileWriter(staticPath + Const.page_files.get(pageId)));
			OutputStreamWriter pw = new OutputStreamWriter(new FileOutputStream(
					(staticPath + Const.page_files.get(pageId))), "UTF-8");
			tpl.merge(ctx, pw);
			pw.flush();
			pw.close();
			return;
		} catch (ResourceNotFoundException e) {
			logger.error("", e);
		} catch (ParseErrorException e) {
			logger.error("", e);
		} catch (MethodInvocationException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		throw new IllegalException(EC.EC_DB);
	}

	public void afterPropertiesSet() throws Exception {
		File f = new File(staticPath);
		if (!f.exists())
			f.mkdirs();

		generateHtml(1); // gen index page
	}
}
