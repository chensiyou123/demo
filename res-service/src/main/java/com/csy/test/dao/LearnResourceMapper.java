package com.csy.test.dao;

import com.csy.test.model.LearnResource;
import com.csy.test.utils.MapperUtil;

import java.util.List;
import java.util.Map;

public interface LearnResourceMapper extends MapperUtil<LearnResource> {
    List<LearnResource> queryLearnResouceList(Map<String, Object> map);
}