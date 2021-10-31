package br.com.ksgprod.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublishHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublishHelper.class);

	private final JmsTemplate jmsTemplate;
	
	@Value("${sqs.queue.example}")
	private String destination;

	public PublishHelper(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(String message) {

		LOGGER.info("stage=init method=PublishHelper.sendMessage destination={} message={}", destination, message);

		jmsTemplate.convertAndSend(this.destination, message);
		
		LOGGER.info("stage=end method=PublishHelper.sendMessage response=void");
	}

}
