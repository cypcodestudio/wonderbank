package com.lekodevs.wonderbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekodevs.wonderbank.entity.WEntity;

@Repository
public interface IWEntityRepository extends JpaRepository<WEntity, Long> {
	WEntity findByEmail(String email);
	WEntity findByMobile(String mobile);
	WEntity findByEntityNo(String entityNo);

}
