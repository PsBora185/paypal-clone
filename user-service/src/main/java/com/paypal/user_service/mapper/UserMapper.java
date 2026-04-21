package com.paypal.user_service.mapper;

import com.paypal.user_service.dto.SignupRequest;
import com.paypal.user_service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User signupRequestDtoToUser(SignupRequest signupRequest);
}

