package com.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolmanagement.dao.StakeholderDAO;
import com.schoolmanagement.model.Stakeholder;
import com.schoolmanagement.service.StakeholderService;

@Service
public class StakeholderServiceImpl implements StakeholderService{
	private StakeholderDAO stakeholderDAO;
	
	public StakeholderDAO getStakeholderDAO() {
		return stakeholderDAO;
	}
	@Autowired
	public void setStakeholderDAO(StakeholderDAO stakeholderDAO) {
		this.stakeholderDAO = stakeholderDAO;
	}

	@Override
	@Transactional
	public void addStakeholder(Stakeholder stakeholder) throws Exception {
		getStakeholderDAO().addStakeholder(stakeholder);
	}

	@Override
	@Transactional
	public void updateStakeholder(Stakeholder stakeholder) throws Exception {
		getStakeholderDAO().updateStakeholder(stakeholder);
	}

	@Override
	@Transactional
	public void removeStakeholder(Stakeholder stakeholder) throws Exception {
		getStakeholderDAO().removeStakeholder(stakeholder);
	}
}
