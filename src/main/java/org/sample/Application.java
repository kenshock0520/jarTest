package org.sample;

import org.sample.domain.service.DbService;
import org.sample.domain.service.PropService;
import org.sample.domain.service.XlsService;
import org.sample.domain.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	@Autowired
	private XmlService xmlService;

	@Autowired
	private XlsService xlsService;

	@Autowired
	private DbService dbService;

	@Autowired
	private PropService propService;

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
        	Application app = ctx.getBean(Application.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run(String... args) throws Exception {
        System.out.println("処理開始");
        //アプリの処理
        xmlService.xmlTest();
        xlsService.xlsTest();
        dbService.dbTest();
        propService.propTest();
        System.out.println("処理終了");
    }
}