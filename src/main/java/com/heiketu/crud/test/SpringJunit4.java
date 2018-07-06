package com.heiketu.crud.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heiketu.crud.bean.Dept;
import com.heiketu.crud.dao.DeptMapper;


@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:ApplicationContext.xml"})
public class SpringJunit4 {

	
	@Autowired
	DeptMapper deptMapper;
	
	@Autowired
	SqlSession sqlSessionBatch;
	
	@Test
	public void test() {
		
//		int insertSelective = deptMapper.insertSelective(new Dept(null, UUID.randomUUID().toString().substring(0, 5)));
//		System.out.println(insertSelective);
		
		
		//批处理操作
		DeptMapper mapper = sqlSessionBatch.getMapper(DeptMapper.class);
		for (int i = 0; i < 1000; i++) {
			mapper.insertSelective(new Dept(null, UUID.randomUUID().toString().substring(0, 5)));
		}
		
	}

}
