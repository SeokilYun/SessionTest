package com.example.sessiontest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class LoginControllerDto {
	private String userid;

	private String userpasswd;
}
