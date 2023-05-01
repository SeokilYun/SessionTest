package com.example.sessiontest.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.sessiontest.controller.dto.LoginControllerDto;
import com.example.sessiontest.service.dto.LoginServiceDto;

@Mapper(componentModel ="spring")
public interface LoginControllerMapper {
	LoginControllerMapper INSTANCE = Mappers.getMapper(LoginControllerMapper.class);
	
	@Mapping(source="id", target="userid")
	@Mapping(source="passwd", target="userpasswd")
	LoginControllerDto loginServiceDtoToControllerDto(LoginServiceDto loginServiceDto);
	@Mapping(source="userid", target="id")
	@Mapping(source="userpasswd", target="passwd")
	LoginServiceDto loginControllerDtoToServiceDto(LoginControllerDto loginServiceDto);
}


