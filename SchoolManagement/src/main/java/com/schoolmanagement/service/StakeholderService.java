package com.schoolmanagement.service;


import com.schoolmanagement.model.Stakeholder;

public interface StakeholderService {
	public void addStakeholder(Stakeholder stakeholder) throws Exception;
	public void updateStakeholder(Stakeholder stakeholder) throws Exception;
	public void removeStakeholder(Stakeholder stakeholder) throws Exception;
}
