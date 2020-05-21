package com.qinkuai.db.dao;

import com.qinkuai.db.model.Student;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    Student selectByPrimaryKey(String id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
    
    List<Student> selectByCourseId(String cid);
}