package com.iu.util;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.iu.s4.AbstractTestCase;

public class ConnectTest extends AbstractTestCase {

	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession.getConnection());
	}

}
