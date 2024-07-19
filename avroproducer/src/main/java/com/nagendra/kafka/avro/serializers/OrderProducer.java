package com.nagendra.kafka.avro.serializers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.nagendra.kafka.avro.Order;

import io.confluent.kafka.serializers.KafkaAvroSerializer;



public class OrderProducer 
{
	public static void main(String[] args) 
	{
		Properties prop = new Properties();
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.serializer", KafkaAvroSerializer.class.getName());
		prop.setProperty("value.serializer",KafkaAvroSerializer.class.getName());
		prop.setProperty("schema.registry.url", "http://localhost:8081");
		
		KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(prop);
		Order order = new Order("Nagendra","NoteBook Pro", 8);
		ProducerRecord<String, Order> record = new ProducerRecord<>("OrderavroTopic",order.getCustomerName().toString(), order);
		
		try
		{
			producer.send(record);
			System.out.println("Message sent Successfully");			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			producer.close();
		}
	}
    
}




