package pl.arkadiusz.SpringAndSwagger.dto;


import pl.arkadiusz.SpringAndSwagger.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    public UserDtoMapper() {

    }

    public static List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .build();
    }


    public static List<UserDto> mapToUserDtosWithAddress(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDtoWithAddress(user))
                .collect(Collectors.toList());
    }

    private static UserDto mapToUserDtoWithAddress(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .address(user.getAddress())
                .build();
    }

}
