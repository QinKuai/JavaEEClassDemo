package com.qinkuai.db.dao;

import com.qinkuai.db.model.Task;
import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    Task selectByPrimaryKey(Integer id);

    List<Task> selectAll();
    
    List<Task> selectByCourseId(String cid);

    int updateByPrimaryKey(Task record);
}