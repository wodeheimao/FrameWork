package com.zelin.mapper;

import com.zelin.pojo.IdCard;
import com.zelin.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IdcardMapper {

    @Results(id = "findIdCardById",value={
            @Result(column = "id",property = "id",id = true),
            @Result(column = "cno",property = "cno"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "uid",property = "user",
                    one = @One(select = "com.zelin.mapper.UserMapper.findUserByUid",fetchType = FetchType.LAZY))
    })
    @Select("select * from tb_idCard where id = #{value}")
    IdCard findIdCardById(int id);
}
