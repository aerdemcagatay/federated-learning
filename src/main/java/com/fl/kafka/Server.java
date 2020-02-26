package com.fl.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

/**
 * Example Server - Kafka Producer
 */
public class Server {


    public static void main(String args[]) {

        // create instance for properties to access producer configs
        Properties props = new Properties();

        //Assign localhost id
        props.put("bootstrap.servers", "localhost:9092");

        //Set acknowledgements for producer requests.
        props.put("acks", "all");

        //If the request fails, the producer can automatically retry,
        props.put("retries", 0);

        //Specify buffer size in config
        props.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        props.put("log4j.rootLogger", "DEBUG, stdout");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);


        Scanner in = new Scanner(System.in);


        while (true) {
            String input = in.nextLine();
            System.out.println("Entered text: " + input);

            producer.send(new ProducerRecord<String, String>("test", "global-model", input));
            System.out.println("MSG sent: " + input);

        }

    }

}
