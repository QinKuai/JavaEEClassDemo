package com.qinkuai.db.dao;

import com.qinkuai.db.model.Teacher;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(String id);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
}