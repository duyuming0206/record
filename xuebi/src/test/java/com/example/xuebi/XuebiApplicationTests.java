package com.example.xuebi;

import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.xuebi.dao.AdminDAO;
import com.example.xuebi.entity.admin;
import com.example.xuebi.server.AdminService;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class XuebiApplicationTests {
	@MockBean AdminDAO adminDAO;
	@Autowired  AdminService service;
	
	@Before
    public void init() {
		
		
		
		}

	@Test
	void contextLoads() {
		admin mockrs =new admin ();
		mockrs.setAname("testname");
		when(adminDAO.getByName(anyString())).thenReturn(mockrs);
		admin rs=service.getByName("a");
		assertTrue(rs.getAname()!=null);
	}

}
