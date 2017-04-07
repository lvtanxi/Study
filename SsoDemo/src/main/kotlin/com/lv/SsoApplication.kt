package com.lv

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SsoApplication{
    companion object{
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(SsoApplication::class.java, *args)
        }
    }
}
