package com.joker.servicesecond.servicesecond;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
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

}

interface ConsumerMQChannel {
	String CONSUMER = "consumer";

	@Input(CONSUMER)
	SubscribableChannel consumer();
}
