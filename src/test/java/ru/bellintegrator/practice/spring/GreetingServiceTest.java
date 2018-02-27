package ru.bellintegrator.practice.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingServiceTest {

    /**
     * Объекты randomMessage и randomGreetingService не создаются, т.к. в конфигурации для них прописано lazy-init="true"
     * и в этом тесте они не используются
     */
    @Test
    public void greeting() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);

        Assert.assertEquals("Hello", greetingService.hello());
    }

    /**
     * Проверяем, что при каждом обращении к greetingService формируется новое случайное сообщение
     */
    @Test
    public void prototypeInSingletonTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        GreetingService greetingService = context.getBean("randomGreetingService", GreetingService.class);

        String firstHello = greetingService.hello();
        String secondHello = greetingService.hello();

        Assert.assertNotEquals(firstHello, secondHello);
    }

    /**
     * В логах можно увидеть, что PreDestroy метод вызывается только у GreetingServiceImpl
     */
    @Test
    public void prototypeInSingletonFailTest() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        GreetingService greetingService = context.getBean(GreetingService.class);

        String firstHello = greetingService.hello();
        String secondHello = greetingService.hello();

        Assert.assertEquals(firstHello, secondHello);

        context.close();
    }

    @Test
    public void mixedConfigurationTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mixedConfig.xml");
        GreetingService greetingService = context.getBean(GreetingService.class);

        Assert.assertEquals("Hello", greetingService.hello());
    }
}
