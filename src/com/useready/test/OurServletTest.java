package com.useready.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.useready.code.*;

class OurServletTest {

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testOurServlet() {
		OurServlet servlet =new OurServlet();
		assertTrue(servlet instanceof HttpServlet);
	}

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		
		StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);
		OurServlet servlet =new OurServlet();
		servlet.doGet(request, response);
		String result = sw.getBuffer().toString().trim();
		assertEquals(result, new String("Served always fresh"));
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse()throws ServletException, IOException {
		StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);
		OurServlet servlet =new OurServlet();
		servlet.doPost(request, response);
		String result = sw.getBuffer().toString().trim();
		assertEquals(result, new String("Served always fresh"));
	}

}
