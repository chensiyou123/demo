package com.csy.test.service;

import com.csy.test.model.view.LeanQueryLeanListReq;
import com.csy.test.model.LearnResource;
import com.csy.test.utils.Page;

import java.util.List;

public interface LearnService  extends IService<LearnResource> {
    public List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page);
    public void deleteBatch(Long[] ids);
}
