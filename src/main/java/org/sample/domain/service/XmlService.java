package org.sample.domain.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.springframework.stereotype.Service;

@Service
public class XmlService {
	public void xmlTest() {
		//曜日リストを作成
		List<String> weeks = new ArrayList<>();
		weeks.add("Sunday");
		weeks.add("Monday");
		weeks.add("Tuesday");
		weeks.add("Wednesday");
		weeks.add("Friday");
		weeks.add("Saturday");

		//Configに設定してマーシャル
		Config config = new Config();
		config.setWeeks(weeks);
		try (BufferedWriter writer = Files.newBufferedWriter(
				Paths.get("/Applications/Eclipse_4.8.0.app/Contents/workspace/jartest/work/config.xml"))) {
			JAXB.marshal(config, writer);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private static class Config {

		private List<String> weeks;

		@XmlElementWrapper(name = "weeks")
		@XmlElement(name = "week")
		public List<String> getWeeks() {
			return weeks;
		}

		public void setWeeks(List<String> weeks) {
			this.weeks = weeks;
		}
	}
}