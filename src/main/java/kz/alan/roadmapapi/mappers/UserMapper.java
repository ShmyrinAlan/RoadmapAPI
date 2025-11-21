package kz.alan.roadmapapi.mappers;

import kz.alan.roadmapapi.model.dtos.UserDTO;
import kz.alan.roadmapapi.model.dtos.UserInDTO;
import kz.alan.roadmapapi.model.dtos.UserOutDTO;
import kz.alan.roadmapapi.model.dtos.shorts.UserShortDTO;
import kz.alan.roadmapapi.model.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(Users user);
    Users toEntity(UserDTO userDTO);
    UserDTO toDTO(UserInDTO userDTO);
    UserOutDTO toOutDTO(Users user);
    List<UserOutDTO> toOutDTO(List<Users> user);
    List<UserDTO> toDTO(List<Users> user);
    List<Users> toEntity(List<UserInDTO> userDTO);
    UserShortDTO toShortDTO(Users user);
    List<UserShortDTO> toShortDTO(List<Users> user);
}