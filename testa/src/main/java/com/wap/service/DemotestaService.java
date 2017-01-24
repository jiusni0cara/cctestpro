package com.wap.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.wap.dao.DemotestaDao;

/**
 * 
 * <br>
 * <b>功能：</b>DemotestaService<br>
 * <b>作者：</b>www.jeecg.org<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 * <b>版权所有：<b>版权所有(C) 2013，www.jeecg.org<br>
 */
@Service("demotestaService")
public class DemotestaService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(DemotestaService.class);
	

	

	@Autowired
    private DemotestaDao<T> dao;

		
	public DemotestaDao<T> getDao() {
		return dao;
	}

}
