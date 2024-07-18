package com.wissen.kafka.orderproducer.customserializers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class OrderProducer {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		prop.setProperty("value.serializer", "com.wissen.kafka.orderproducer.customserializers.OrderSerializer");
		
		KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(prop);
		Order order = new Order();
		order.setCustomerName("Rohan");
		order.setProduct("Poco X5 Pro");
		order.setQuantity(6);
		ProducerRecord<String, Order> record = new ProducerRecord<String, Order>("OrderSerDeserTopic", order.getCustomerName(), order);
		
		try {
			 producer.send(record); 
			 System.out.println("message is sent successfully");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}

	}

}
