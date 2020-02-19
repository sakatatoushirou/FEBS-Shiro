package cc.mrbird.febs.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.DeptTree;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.dept.service.DeptServiceInt;
import cc.mrbird.febs.system.entity.Dept;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class deptControlle {
	@Autowired
	private DeptServiceInt deptService;

	@RequestMapping("/dept/index")
	public String index(ModelMap map) {

		List<Dept> depts = this.deptService.findDeptsall();
		
		map.addAttribute("depts", depts);
		return FebsUtil.view("dept/deptv");
	}

}
