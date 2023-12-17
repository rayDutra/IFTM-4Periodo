package org.example;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KeywordMapper extends Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private final Text teste = new Text();

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            StringTokenizer tk = new StringTokenizer(value.toString());
            String token = tk.nextToken();
            if (token.contains("Type")){
                token= tk.nextToken();
                teste.set(token.toLowerCase().replaceAll("[^a-zA-Z]", ""));
                context.write(teste, one);
            }

        }
    }


