package com.joker.servicethird.servicethird;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableBinding(ProducerMQChannel.class)
@Component
public class ProducerChannel {

	private final static Logger logger = LoggerFactory.getLogger(ProducerChannel.class);

	@Autowired
	ProducerMQChannel channel;

	@Value("${service3: Default Service Third}")
	private String message;

	@Scheduled(fixedRate = 1000 * 60 * 2)
	public void send() {
		logger.info("Inside service third.......");
		Message<String> msg = MessageBuilder.withPayload("Message from service third : - " + message).build();
		logger.info("Sending message to MQ. " + msg);
		channel.producer().send(msg);
	}

}

interface ProducerMQChannel {

	@Output("producer")
	MessageChannel producer();
}
