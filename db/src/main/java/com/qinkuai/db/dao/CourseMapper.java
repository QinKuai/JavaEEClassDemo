package com.qinkuai.db.dao;

import com.qinkuai.db.model.Course;
import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Course record);

    Course selectByPrimaryKey(String id);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);
}