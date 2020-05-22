package com.etoak.service;

import java.util.List;

import com.etoak.bean.Dict;

public interface DictService {
	//根据
	List<Dict> queryList(String groupId);
}
