package com.wissen.kafka.OrderConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class OrderConsumer {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		prop.setProperty("value.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
		prop.setProperty("group.id", "OrderGroup");
		
		KafkaConsumer<String, Integer> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Collections.singletonList("OrderTopic"));
		
		ConsumerRecords<String, Integer> orders = consumer.poll(Duration.ofSeconds(20));
		for(ConsumerRecord<String, Integer> order: orders) {
			System.out.println("Product Name: " + order.key()); //Product Name
			System.out.println("Product Price: " + order.value()); //Product Price
		}
		consumer.close();
	}

}
