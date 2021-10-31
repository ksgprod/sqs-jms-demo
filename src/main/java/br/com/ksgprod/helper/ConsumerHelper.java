package br.com.ksgprod.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerHelper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerHelper.class);
	
	@JmsListener(destination = "${sqs.queue.example}")
	public void onMessage(@Payload String message) {
		
		LOGGER.info("stage=info method=ConsumerHelper.onMessage message={}", message);
		
	}

}
