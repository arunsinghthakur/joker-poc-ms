package com.joker.servicesecond;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@EnableBinding(ConsumerMQChannel.class)
@Component
public class ConsumerChannel {

	private final static Logger logger = LoggerFactory.getLogger(ConsumerChannel.class);

	@Autowired
	ConsumerMQChannel channel;

	String msg;

	@StreamListener(target = ConsumerMQChannel.CONSUMER)
	public void fetchMsg(String msg) {
		logger.info("Message from rabiitmq -" + msg);
		this.msg += msg;
	}

	String getMsg() {
		return msg;
	}

	@Bean
	public IntegrationFlow handle() {
		return IntegrationFlows
				.from(channel.iconsumer())
				.handle(String.class, (payload, headers) -> {
			logger.info("Message from rabiitmq -" + payload);
			return null;
		}).get();
	}

}

interface ConsumerMQChannel {
	String CONSUMER = "consumer";

	@Input(CONSUMER)
	SubscribableChannel consumer();

	String iCONSUMER = "integrationConsumer";

	@Input(iCONSUMER)
	SubscribableChannel iconsumer();

}
