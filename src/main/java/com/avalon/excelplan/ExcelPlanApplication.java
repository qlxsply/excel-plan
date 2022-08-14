package com.avalon.excelplan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = {"com.avalon.excelplan.mapper"})
@SpringBootApplication
public class ExcelPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelPlanApplication.class, args);
    }

}
