package com.ameda.works.user_service.mapper;

import com.ameda.works.user_service.dto.UserDTO;
import com.ameda.works.user_service.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DTOMapper {


    public abstract User map(UserDTO userDTO);
    public abstract UserDTO map(User user);
}
