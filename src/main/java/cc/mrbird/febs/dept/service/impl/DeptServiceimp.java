package cc.mrbird.febs.dept.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cc.mrbird.febs.common.entity.DeptTree;
import cc.mrbird.febs.common.utils.TreeUtil;
import cc.mrbird.febs.dept.service.DeptServiceInt;
import cc.mrbird.febs.system.entity.Dept;
import cc.mrbird.febs.system.mapper.DeptMapper;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceimp extends ServiceImpl<DeptMapper, Dept> implements DeptServiceInt{

	@Override
	public List<DeptTree<Dept>> findDepts() {
		// TODO Auto-generated method stub
		List<Dept> depts = this.baseMapper.selectList(new QueryWrapper<>());
		List<DeptTree<Dept>> trees = this.convertDepts(depts);

		return TreeUtil.buildDeptTree(trees);
	}

	
    private List<DeptTree<Dept>> convertDepts(List<Dept> depts){
        List<DeptTree<Dept>> trees = new ArrayList<>();
        depts.forEach(dept -> {
            DeptTree<Dept> tree = new DeptTree<>();
            tree.setId(String.valueOf(dept.getDeptId()));
            tree.setParentId(String.valueOf(dept.getParentId()));
            tree.setName(dept.getDeptName());
            tree.setData(dept);
            trees.add(tree);
        });
        return trees;
    }


	@Override
	public List<Dept> findDeptsall() {
		// TODO Auto-generated method stub

		
		return this.baseMapper.selectList(new QueryWrapper<>());
	}


	@Override
	public Dept findDept(Long id) {
		// TODO Auto-generated method stub
		return this.baseMapper.selectById(id);
	}


	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
	     dept.setModifyTime(new Date());
	        this.baseMapper.updateById(dept);
	}


	@Override
	public void createDept(Dept dept) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteDepts(String[] deptIds) {
		// TODO Auto-generated method stub
		
	}


	
}
