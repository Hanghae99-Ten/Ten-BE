package com.sparta.ten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.ApplicationContext;
//import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication(
		exclude = {
				org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
				org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
				org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class
		}
)
public class TenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenApplication.class, args);
//		ApplicationContext ctx = SpringApplication.run(TenApplication.class, args);
//		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//		String val = template.opsForValue().get("testkey1");
//		System.out.println(val);
//
//		val = template.opsForValue().get("testkey2");
//		System.out.println(val);
	}

}
