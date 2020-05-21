package com.qinkuai.db.dao;

import com.qinkuai.db.model.Homework;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Homework record);

    Homework selectByPrimaryKey(Integer id);

    List<Homework> selectAll();

    int updateByPrimaryKey(Homework record);
    
    List<Homework> selectByStudentIdAndTaskId(@Param("sid") String sid, @Param("taskId") Integer taskId);
    
    List<Homework> selectByTaskId(Integer taskId);
}