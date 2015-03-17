package com.haf.cwrw.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haf.cwrw.model.SkeletonModel;
import com.haf.cwrw.repository.SkeletonRepository;

@Service("skeletonService")
public class SkeletonService {
	
	@Autowired
	private SkeletonRepository skeletonRepository;

	public void setSkeletonRepository(SkeletonRepository skeletonRepository) {
		this.skeletonRepository = skeletonRepository;
	}
	
	@Transactional
	public void registerSkeleton(SkeletonModel skeletonModel){
		skeletonRepository.save(skeletonModel);
	}

	@Transactional
	public SkeletonModel registerSkeleton(String name, String description) {
		
		SkeletonModel model = new SkeletonModel(name);
		model.setDescription(description);
		
		return skeletonRepository.save(model);
	}

	@Transactional
	public SkeletonModel getSkeletonById(long skeletonId) {
		return skeletonRepository.getSkeletonById(skeletonId);
	}

}
