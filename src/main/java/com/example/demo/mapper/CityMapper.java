package com.example.demo.mapper;

import com.example.demo.City;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CityMapper {
    List<City> findByState(String state);

    @Insert("INSERT INTO City(NAME, STATE) VALUES(#{name}, #{state})")
    int insert(@Param("name") String name, @Param("state") String state);

    @Select("SELECT * FROM CITY WHERE NAME = #{name}")
    City findByName(@Param("name") String name);

    //根据state更新 name
    @Update("UPDATE CITY SET NAME = #{name} WHERE STATE= #{state}")
    int update(@Param("name") String name, @Param("state") String state);

    @Delete("DELETE FROM CITY WHERE STATE = #{state}")
    int delete(@Param("state")String state);
}
