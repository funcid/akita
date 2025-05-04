package me.func.akita.ports

import feign.RequestInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class YandexApiConfig {
    @Value("\${yandex-api.token}")
    private lateinit var token: String

    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { template ->
            template.header("Authorization", "Bearer $token")
        }
    }
}
