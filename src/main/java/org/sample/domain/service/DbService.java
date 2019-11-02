package org.sample.domain.service;

import org.sample.domain.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
	@Autowired
	private SampleMapper sampleMapper;

	public void dbTest() {
		System.out.println("calc:"+sampleMapper.calc());
	}
}