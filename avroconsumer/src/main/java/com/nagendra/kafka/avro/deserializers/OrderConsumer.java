package com.nagendra.kafka.avro.deserializers;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.nagendra.kafka.avro.Order;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;


public class OrderConsumer {

	public static void main(String[] args) 
	{
		Properties prop = new Properties();
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.deserializer", KafkaAvroDeserializer.class.getName());
		prop.setProperty("value.deserializer",KafkaAvroDeserializer.class.getName());
		prop.setProperty("group.id", "OrderGroup");
		prop.setProperty("schema.registry.url", "http://localhost:8081");
		prop.setProperty("specific.avro.reader", "true");
		
		KafkaConsumer<String, Order> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Collections.singletonList("OrderavroTopic"));
		
		ConsumerRecords<String, Order> records = consumer.poll(Duration.ofSeconds(20));
		for (ConsumerRecord<String, Order> record: records) {
			String customerName = record.key();
			Order order = record.value();
			System.out.println("Customer Name : "+customerName);
			System.out.println("Product Name : "+order.getProduct());
			System.out.println("Quantity : "+order.getQuantity());
		}
		consumer.close();
	}

}
