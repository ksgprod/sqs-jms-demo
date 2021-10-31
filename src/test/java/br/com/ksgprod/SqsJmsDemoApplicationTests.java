package br.com.ksgprod;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.ksgprod.helper.PublishHelper;

@SpringBootTest
class SqsJmsDemoApplicationTests {
	
	@Autowired
	private PublishHelper helper;

	@Test
	public void contextLoads() {
		String message = "Test message";
		this.helper.sendMessage(message);
	}

}
