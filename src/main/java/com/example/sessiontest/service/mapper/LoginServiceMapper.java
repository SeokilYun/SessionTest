package com.example.sessiontest.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.sessiontest.entity.LoginEntity;
import com.example.sessiontest.service.dto.LoginServiceDto;

@Mapper(componentModel ="spring")
public interface LoginServiceMapper {
	LoginServiceMapper INSTANCE = Mappers.getMapper(LoginServiceMapper.class);
	
	LoginServiceDto loginEntityToDto(LoginEntity loginEntity);
	LoginEntity loginDtoToEntity(LoginServiceDto loginEntity);
}
