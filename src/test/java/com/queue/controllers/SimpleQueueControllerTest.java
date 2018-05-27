package com.queue.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SimpleQueueControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext ctx;
	
	@Before
    public void setup () {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.ctx);
        this.mockMvc = builder.build();
    }
	
	@Test 
	public void giventUrl_whenPostRequest_thenFindPostResponse() throws Exception {
	    
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/testpost");
		
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content().string("POST Response");
//		
//		this.mockMvc.perform(builder).andExpect(contentMatcher).andExpect(MockMvcResultMatchers.status().isOk());
//		
	}
	
	//@Test
	public void testPostRequest() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/queue/post");
		
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().string("added");
		
		this.mockMvc.perform(builder).andExpect(contentMatcher)
			.andExpect(MockMvcResultMatchers.status().isOk());
				
	}
	
}
