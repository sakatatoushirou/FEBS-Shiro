package cc.mrbird.febs.dept.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cc.mrbird.febs.common.entity.DeptTree;
import cc.mrbird.febs.system.entity.Dept;

public interface DeptServiceInt extends IService<Dept>{

	List<DeptTree<Dept>> findDepts();

	List<Dept> findDeptsall();

	Dept findDept(Long id);

	 /**
     * 新增部门
     *
     * @param dept 部门对象
     */
    void createDept(Dept dept);
	
    /**
     * 修改部门
     *
     * @param dept 部门对象
     */
	void updateDept(Dept dept);
	 /**
     * 删除部门
     *
     * @param deptIds 部门 ID集合
     */
    void deleteDepts(String[] deptIds);
}
