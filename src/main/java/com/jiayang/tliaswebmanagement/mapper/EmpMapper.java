package com.jiayang.tliaswebmanagement.mapper;

import com.jiayang.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp")
//    public Long count();
//
//
//    @Select(" select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);


//    @Select(" select * from emp")

    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);


    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete  from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
