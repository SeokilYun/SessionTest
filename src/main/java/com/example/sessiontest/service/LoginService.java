package com.example.sessiontest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sessiontest.entity.LoginEntity;
import com.example.sessiontest.repository.LoginRepository;
import com.example.sessiontest.service.dto.LoginServiceDto;
import com.example.sessiontest.service.mapper.LoginServiceMapper;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private LoginServiceMapper loginMapper;

	public List<LoginServiceDto> findById(String userID) {
		return (List<LoginServiceDto>) loginRepository.findById(userID);
	}

	public boolean CheckLoginInfo(LoginServiceDto loginDto) {
		LoginServiceDto userInfo = this.getUserInfo(loginDto.getId());
		if (userInfo == null) {
			throw new NullPointerException();
		}
		if (userInfo.getId().equals(userInfo.getId()) && userInfo.getPasswd().equals(loginDto.getPasswd())) {
			return true;
		} else {
			return false;
		}
	}

	private LoginServiceDto getUserInfo(String id) {
		LoginEntity queryResult = loginRepository.findById(id);
		LoginServiceDto result =loginMapper.loginEntityToDto(queryResult);
		return result;
	}

	public LoginServiceDto save(LoginServiceDto loginDto) {
		LoginEntity loginEntity = loginMapper.loginDtoToEntity(loginDto);
		LoginEntity saveResult = loginRepository.save(loginEntity);
		LoginServiceDto saveResultDto = loginMapper.loginEntityToDto(saveResult);
		return saveResultDto;
	}
}
