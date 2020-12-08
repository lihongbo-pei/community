package com.lhb.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author littlelee
 * @date 2020/12/2 23:52
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
