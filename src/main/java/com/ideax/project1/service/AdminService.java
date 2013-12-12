package com.ideax.project1.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.dao.AdminDAO;
import com.ideax.project1.dao.BlockDAO;
import com.ideax.project1.dao.LanmuDAO;
import com.ideax.project1.pojo.Admin;
import com.ideax.project1.pojo.User;
import com.ideax.project1.query.AdminQuery;

@Service
public class AdminService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BlockDAO blockDAO;
    @Autowired
    LanmuDAO lanmuDAO;
    @Autowired
    AdminDAO adminDAO;

    public Admin verifyUser(String username, String passwordmd5) {
        try {
            List<Admin> list = adminDAO.getAdminList(new AdminQuery().setUsername(username).setPassword(passwordmd5));
            if (list != null && list.size() > 0)
                return list.get(0);
            return null;
        } catch (SQLException e) {
            logger.error("", e);
            throw new IllegalException(EC.EC_DB);
        }
    }
}
