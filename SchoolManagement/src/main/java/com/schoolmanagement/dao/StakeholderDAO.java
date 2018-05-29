package com.schoolmanagement.dao;


import com.schoolmanagement.model.Stakeholder;


public interface StakeholderDAO {
	public void addStakeholder(Stakeholder stakeholder) throws Exception;
	public void updateStakeholder(Stakeholder stakeholder) throws Exception;
	public void removeStakeholder(Stakeholder stakeholder) throws Exception;
}
