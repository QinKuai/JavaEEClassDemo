package com.qinkuai.db.dao;

import com.qinkuai.db.model.CourseSelection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseSelectionMapper {
    int deleteByPrimaryKey(@Param("sid") String sid, @Param("cid") String cid);

    int insert(CourseSelection record);

    CourseSelection selectByPrimaryKey(@Param("sid") String sid, @Param("cid") String cid);

    List<CourseSelection> selectAll();

    int updateByPrimaryKey(CourseSelection record);
}