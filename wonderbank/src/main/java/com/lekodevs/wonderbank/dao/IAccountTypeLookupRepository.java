package com.lekodevs.wonderbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekodevs.wonderbank.entity.AccountTypeLookup;

@Repository
public interface IAccountTypeLookupRepository extends JpaRepository<AccountTypeLookup, Long>{
	AccountTypeLookup findByName(String name);
}
