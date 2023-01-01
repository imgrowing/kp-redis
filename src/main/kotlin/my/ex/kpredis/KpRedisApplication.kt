package my.ex.kpredis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KpRedisApplication

fun main(args: Array<String>) {
    runApplication<KpRedisApplication>(*args)
}
