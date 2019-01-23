package com.shenjg.auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置restTemplete
 *
 * @author shenjg
 * @date 2018/12/27
 */
@Configuration
public class RestTemplateConfiguration {

	/**
	 * restTemplate 配置
	 *
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}
}
