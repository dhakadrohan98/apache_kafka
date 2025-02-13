package com.wissen.kafka.orderproducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderProducer {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		prop.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		
		KafkaProducer<String, Integer> producer = new KafkaProducer<String, Integer>(prop);
		ProducerRecord<String, Integer> record = new ProducerRecord<String, Integer>("OrderTopic", "Iphone", 
				165);
		
		try {
			/*
			 * producer.send(record); 
			 * System.out.println("message is sent successfully");
			 */
			
			//Synchronous send
			/*
			 * RecordMetadata recordMetadata = producer.send(record).get();
			 * System.out.println(recordMetadata.partition());
			 * System.out.println(recordMetadata.offset());
			 * System.out.println("message is sent successfully");
			 */
			
			//Asynchronous send
			producer.send(record, new OrderCallback());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}

	}

}

//Product -> name(String), price(Integer)
