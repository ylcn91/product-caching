package com.doksanbir.productcaching.service;

import com.doksanbir.productcaching.model.dto.UserDtoGet;
import com.doksanbir.productcaching.model.dto.UserDtoPost;

import java.util.List;

public interface UserService  {
    UserDtoPost createUser(UserDtoPost user);
    UserDtoGet getUser(String email);
    List<UserDtoGet> getUsers(int page, int limit);
}
