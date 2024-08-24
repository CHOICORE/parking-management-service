package me.choicore.samples.parking

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.ZoneId
import java.util.Locale
import java.util.TimeZone

@SpringBootApplication
class Application {
    @Bean
    fun initializer(): CommandLineRunner = CommandLineRunner {
        Locale.setDefault(Locale.KOREA)
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Seoul")))
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}