package cc.mrbird.febs.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.DeptTree;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.dept.service.DeptServiceInt;
import cc.mrbird.febs.system.entity.Dept;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/dept/api/")
public class DetpAPI {
	@Autowired
	private DeptServiceInt deptService;


	@RequestMapping(value = "findDept", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Dept FinfDept(@RequestBody(required = false) String j) {
		
		JSONObject jObject = JSONObject.parseObject(j);
		Dept dept = jObject.toJavaObject(Dept.class);
		return this.deptService.findDept(dept.getDeptId());
	}

	@RequestMapping(value = "update", produces = "application/json;charset=UTF-8")
	public FebsResponse DeptChange(@RequestBody(required = false) String j) {
		JSONObject jObject = JSONObject.parseObject(j);
		Dept dept = jObject.toJavaObject(Dept.class);
		
		this.deptService.updateDept(dept);
		return new FebsResponse().success();

	}

}
