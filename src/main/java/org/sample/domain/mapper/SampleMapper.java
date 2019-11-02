package org.sample.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMapper {

    @Select("SELECT 100 * 200")
    long calc();
}