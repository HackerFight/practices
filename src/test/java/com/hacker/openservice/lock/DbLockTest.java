package com.hacker.openservice.lock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:58
 *
 * @desc
 */
public class DbLockTest {

    public static void main(String[] args) {

        //ApplicationContext-lock.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/spring/ApplicationContext-lock.xml");

        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

        System.out.println(ctx.getApplicationName());
    }
}
