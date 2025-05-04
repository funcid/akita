package me.func.akita

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class AkitaApplication

fun main(args: Array<String>) {
    runApplication<AkitaApplication>(*args)
}
