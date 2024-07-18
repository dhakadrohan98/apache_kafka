package com.wissen.kafka.OrderConsumer.deserializers;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class OrderConsumer {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.deserializer", StringDeserializer.class.getName());
		prop.setProperty("value.deserializer", OrderDeserializer.class.getName());
		prop.setProperty("group.id", "OrderGroup");

		KafkaConsumer<String, Order> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Collections.singletonList("OrderSerDeserTopic"));

		ConsumerRecords<String, Order> records = consumer.poll(Duration.ofSeconds(20));
		for (ConsumerRecord<String, Order> record : records) {
			String customerName = record.key();
			Order order = record.value();
			System.out.println("customer name: " + customerName);
			System.out.println("product name: " + order.getProduct());
			System.out.println("product quantity: " + order.getQuantity());
		}
		consumer.close();
	}

}
