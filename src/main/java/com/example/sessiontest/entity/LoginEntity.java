package com.example.sessiontest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="myuser")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class LoginEntity {
	@Id
	private String id;
	
	private String passwd;
}
