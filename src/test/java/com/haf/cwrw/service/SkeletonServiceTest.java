package com.haf.cwrw.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haf.cwrw.model.SkeletonModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SkeletonServiceTest {
	
	@Autowired
	SkeletonService skeletonService;
	
	@Test
	public void saveSkeletonServiceTest(){
		SkeletonModel model = new SkeletonModel("test");
		skeletonService.registerSkeleton(model);
	}

}
