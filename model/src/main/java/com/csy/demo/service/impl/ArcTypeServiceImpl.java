package com.csy.demo.service.impl;

import com.csy.demo.dao.ArcTypeMapper;
import com.csy.demo.model.ArcType;
import com.csy.demo.service.ArcTypeService;
import com.csy.demo.utils.PageQuery;
import com.csy.demo.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("arcTypeService")
public class ArcTypeServiceImpl implements ArcTypeService {
    @Autowired
    private ArcTypeMapper arcTypeMapper;

    @Override
    public Map<String, Object> save(ArcType arcType) {
        if(arcType==null){
            arcType = new ArcType();
        }
        arcType.setId(UUIDUtils.getUUID());
        arcType.setName("小米");
        arcType.setRemark("123");
        arcTypeMapper.insertSelective(arcType);
        Map map = new HashMap();
        map.put("message","添加成功");
        return map;
    }

    @Override
    public Map<String, Object> update(ArcType arcType) {
        ArcType target = arcTypeMapper.selectByPrimaryKey(arcType.getId());
        if(target==null){
            arcType = new ArcType();
        }
        arcType.setId(target.getId());
        arcType.setName("小米");
        arcType.setRemark("123");
        arcTypeMapper.insertSelective(arcType);
        Map map = new HashMap();
        map.put("message","更新成功");
        return map;
    }


    @Override
    public Map<String, Object> query(PageQuery pageQuery) {
        Map map = pageQuery.convertFilterToMap();
        PageHelper.startPage(1, 10);
        List<ArcType> list = arcTypeMapper.query(map);
        PageInfo<ArcType> page = new PageInfo<ArcType>(list);
        Map resultMap = new HashMap();
        resultMap.put("info",page);
        return resultMap;
    }

    @Override
    public List<ArcType> list(Map map) {
        return arcTypeMapper.query(map);
    }
}
