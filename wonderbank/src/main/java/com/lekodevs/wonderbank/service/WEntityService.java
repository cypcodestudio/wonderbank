package com.lekodevs.wonderbank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lekodevs.wonderbank.dao.IWEntityRepository;
import com.lekodevs.wonderbank.entity.WEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WEntityService {
	private static final Logger LOG = LoggerFactory.getLogger(WEntityService.class);
	
	@Autowired
	IWEntityRepository entityRepository;
	
	public WEntity persistEntity(WEntity entity) {
		return entityRepository.save(entity);
	}
	
	public WEntity findByEmail(String email) {
		return entityRepository.findByEmail(email);
	}
	
	public WEntity findByEntityNo(String entityNo) {
		return entityRepository.findByEntityNo(entityNo);
	}
	
	public WEntity findByMobile(String mobile) {
		return entityRepository.findByMobile(mobile);
	}
	

}
