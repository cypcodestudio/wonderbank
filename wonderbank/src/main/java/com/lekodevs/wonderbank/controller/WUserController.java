package com.lekodevs.wonderbank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lekodevs.wonderbank.entity.User;
import com.lekodevs.wonderbank.entity.WEntity;
import com.lekodevs.wonderbank.entity.dto.UserRegisterRequestDTO;
import com.lekodevs.wonderbank.entity.param.EntityResponse;
import com.lekodevs.wonderbank.entity.param.UserRoleRequestParam;
import com.lekodevs.wonderbank.security.JWTTokenUtil;
import com.lekodevs.wonderbank.security.SecurityPrincipal;
import com.lekodevs.wonderbank.security.param.AuthenticationRequest;
import com.lekodevs.wonderbank.security.param.AuthenticationResponse;
import com.lekodevs.wonderbank.service.WEntityService;
import com.lekodevs.wonderbank.service.WUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class WUserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	WUserService userService;
	

	@Autowired
	WEntityService entityService;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		} catch (Exception e) {
			return EntityResponse.generateResponse("Authentication Failed", HttpStatus.OK,
					"Invalid credentials, please check details and try again.");
		}
		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);

		return EntityResponse.generateResponse("Authentication", HttpStatus.OK,
				new AuthenticationResponse(token, refreshToken));

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@GetMapping("/is-authenticated")
	@ResponseBody
	public ResponseEntity<Object> isUserAuthenticated() {
		User principal = SecurityPrincipal.getInstance().getLoggedInPrincipal();
		if (principal != null) {
			return EntityResponse.generateResponse("Authenticated", HttpStatus.OK, true);
		}
		return EntityResponse.generateResponse("Unauthorized", HttpStatus.OK, false);
	}

	@GetMapping("/registered")
	@ResponseBody
	public ResponseEntity<Object> isUserRegistered(@RequestParam("username") String username) {
		if (userService.findByUsername(username) != null) {
			return EntityResponse.generateResponse("Registered", HttpStatus.OK, true);
		}
		return EntityResponse.generateResponse("Registered", HttpStatus.OK, false);
	}

	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Object> getUser() {
		WEntity user = entityService.findByEntityNo(SecurityPrincipal.getInstance().getLoggedInPrincipal().getEntityNo());
		return EntityResponse.generateResponse("Retrieve User Success", HttpStatus.OK, user);
	}
	

	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<Object> createUser(@RequestBody UserRegisterRequestDTO user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		String response = userService.createUser(user);

		return EntityResponse.generateResponse("Create", HttpStatus.CREATED, response);

	}

	@PostMapping("/user-role")
	@ResponseBody
	public void createUserRoel(@RequestBody UserRoleRequestParam param) {
		try {
			userService.addUserRoleByUsernameAndRoleName(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}