package e.sen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 *   @Project: service-asset
 *   @Package: e.sen
 *   @Author:  Iamee
 *   @Date:    2019-05-07 17:08
 */

@SpringBootApplication
class AxonDisruptorDemoApplication

fun main(args: Array<String>) {
    runApplication<AxonDisruptorDemoApplication>(*args)
}