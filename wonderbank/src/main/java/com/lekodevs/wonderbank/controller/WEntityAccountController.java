package com.lekodevs.wonderbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lekodevs.wonderbank.entity.dto.AccountCreateRequestDTO;
import com.lekodevs.wonderbank.entity.dto.TransactRequestDTO;
import com.lekodevs.wonderbank.entity.dto.TransferRequestDTO;
import com.lekodevs.wonderbank.entity.param.EntityResponse;
import com.lekodevs.wonderbank.service.WEntityAccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bank")
public class WEntityAccountController {

	@Autowired
	WEntityAccountService entityAccountService;
	
	
	@PostMapping("/create-account")
	@ResponseBody
	public ResponseEntity<Object> createAccount(@RequestBody AccountCreateRequestDTO requestDTO) {
		return EntityResponse.generateResponse("Create Account", HttpStatus.OK, entityAccountService.createAccount(requestDTO));
	}
	
	@PostMapping("/deposit")
	@ResponseBody
	public ResponseEntity<Object> deposit(@RequestBody TransactRequestDTO requestDTO) {
		return EntityResponse.generateResponse("Deposit", HttpStatus.OK, entityAccountService.deposit(requestDTO));
	}
	
	@GetMapping("/balance/{account}")
	@ResponseBody
	public ResponseEntity<Object> balance(@PathVariable String account) {
		return EntityResponse.generateResponse("Balance", HttpStatus.OK, entityAccountService.getAccountBalance(account));
	}
	
	@PostMapping("/withdraw")
	@ResponseBody
	public ResponseEntity<Object> withdraw(@RequestBody TransactRequestDTO requestDTO) {
		return EntityResponse.generateResponse("Withdraw", HttpStatus.OK, entityAccountService.withdraw(requestDTO));
	}
	
	@PostMapping("/transfer")
	@ResponseBody
	public ResponseEntity<Object> transfer(@RequestBody TransferRequestDTO requestDTO) {
		return EntityResponse.generateResponse("Transfer", HttpStatus.OK, entityAccountService.transfer(requestDTO));
	}
}
