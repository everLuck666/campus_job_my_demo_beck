package net.seehope;

import net.seehope.task.MyTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Calendar;
import java.util.Timer;

@MapperScan("net.seehope.**.mapper")
@SpringBootApplication
@EnableScheduling
@EnableAsync
@ServletComponentScan
@EnableSwagger2
public class Application{
    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);
    }
}
