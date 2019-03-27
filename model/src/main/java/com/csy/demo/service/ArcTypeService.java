package com.csy.demo.service;

import com.csy.demo.model.ArcType;
import com.csy.demo.model.User;
import com.csy.demo.utils.PageQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */

public interface ArcTypeService {

    Map<String,Object>save(ArcType arcType);

    Map<String,Object>update(ArcType arcType);

    Map<String,Object>query(PageQuery pageQuery);

    List<ArcType>list(Map map);




}
