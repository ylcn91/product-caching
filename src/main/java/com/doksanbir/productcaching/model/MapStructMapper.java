package com.doksanbir.productcaching.model;

import com.doksanbir.productcaching.model.dto.*;
import com.doksanbir.productcaching.model.entity.Brand;
import com.doksanbir.productcaching.model.entity.Phone;
import com.doksanbir.productcaching.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    PhoneIdNameDto phoneIdNameDto(Phone phone);
    PhoneDto phoneDto(Phone phone);

    BrandOnlyDto brandOnlyDto(Brand brand);
    BrandWithPhoneDto brandWithPhoneDto(Brand brand);

    List<BrandWithPhoneDto> brandWithPhoneDtoList(List<Brand> brands);

    UserDtoGet userDtoGet(User user);
    User userPost(UserDtoPost userDtoPost);

}
