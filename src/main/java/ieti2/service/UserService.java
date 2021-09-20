package ieti2.service;

import ieti2.dto.UserDto;
import ieti2.repository.UserDocument;

import java.util.List;

public interface UserService {
    UserDocument create(UserDocument user );

    UserDocument findById( String id );

    List<UserDocument> all();

    boolean deleteById( String id );

    UserDocument update(UserDto userDto, String id );
}
