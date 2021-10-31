package br.com.ksgprod.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
@EnableJms
public class JmsConfig {
	
	@Value("${cloud.aws.host}")
	private String host;
	
	@Value("${cloud.aws.region}")
	private String region;
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(this.createSQSConnectionFactory());
		return factory;
	}
	
	@Bean
    public JmsTemplate jmsTemplate() {
	     return new JmsTemplate(this.createSQSConnectionFactory());
    }
	
	private SQSConnectionFactory createSQSConnectionFactory() {
		
		AmazonSQSClientBuilder sqsBuilder = AmazonSQSClient.builder();

		sqsBuilder.withEndpointConfiguration(new EndpointConfiguration(host, region));
		
		return new SQSConnectionFactory(new ProviderConfiguration(), sqsBuilder.build());
	}
	
}
