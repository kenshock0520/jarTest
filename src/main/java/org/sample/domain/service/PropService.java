package org.sample.domain.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class PropService {
	public void propTest() {
		 Map<String, String> map = new TreeMap<>(); // <-- sort
	        map.put("key1", "val1");
	        map.put("key2", "val2");
	        map.put("key3", "val3");
	        map.put("key4", "val4");
	        map.put("key5", "val5");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("/Applications/Eclipse_4.8.0.app/Contents/workspace/jartest/work/test.properties"), Charset.forName("UTF-8"));) {
            for (String key : map.keySet()) {
                String line = key + "=" + map.get(key);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
        }
	}

}