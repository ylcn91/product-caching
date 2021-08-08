package com.doksanbir.productcaching.service.impl;

import com.doksanbir.productcaching.exceptions.UserServiceException;
import com.doksanbir.productcaching.model.MapStructMapper;
import com.doksanbir.productcaching.model.dto.UserDtoGet;
import com.doksanbir.productcaching.model.dto.UserDtoPost;
import com.doksanbir.productcaching.model.entity.User;
import com.doksanbir.productcaching.repositories.UserRepository;
import com.doksanbir.productcaching.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private MapStructMapper mapStructMapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(MapStructMapper mapStructMapper, UserRepository userRepository) {
        this.mapStructMapper = mapStructMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDtoPost createUser(UserDtoPost user) {
        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new UserServiceException("Record already exists");

        log.warn(user.toString());
        userRepository.save(mapStructMapper.userPost(user));

         return user;
    }

    @Cacheable("user")
    @Override
    public UserDtoGet getUser(String email) {
        try {
            System.out.println("To simulate backend call.");
            Thread.sleep(1000*5);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (userRepository.findByEmail(email) == null)
            throw new UserServiceException("Record not found");

        return mapStructMapper.userDtoGet(userRepository.findByEmail(email));
    }


    //will refactor this method.
    @Override
    public List<UserDtoGet> getUsers(int page, int limit) {
        List<UserDtoGet> returnValue = new ArrayList<>();
        if(page>0) page = page-1;

        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<User> usersPage = userRepository.findAll(pageableRequest);
        List<User> users = usersPage.getContent();

        for (User userEntity : users) {
            UserDtoGet userDto = new UserDtoGet();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }
        return returnValue;
    }
}
