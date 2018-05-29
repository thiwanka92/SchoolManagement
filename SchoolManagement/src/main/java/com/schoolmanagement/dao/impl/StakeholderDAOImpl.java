package com.schoolmanagement.dao.impl;

import org.springframework.stereotype.Repository;

import com.schoolmanagement.dao.StakeholderDAO;
import com.schoolmanagement.model.Stakeholder;
import com.schoolmanagement.utility.BaseDAOSupport;

@Repository
public class StakeholderDAOImpl extends BaseDAOSupport implements StakeholderDAO{
		
	@Override
	public void addStakeholder(Stakeholder stakeholder) throws Exception {
		save(stakeholder);
	}

	@Override
	public void updateStakeholder(Stakeholder stakeholder) throws Exception{
		update(stakeholder);
		
	}

	@Override
	public void removeStakeholder(Stakeholder stakeholder) throws Exception{
		delete(stakeholder);
	}
}
