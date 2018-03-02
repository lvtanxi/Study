package com.example.hot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Date: 2017-12-01
 * Time: 09:05
 * Description:
 */
@RestController
class TestController {

    @GetMapping("/")
    fun hello()="你好，sad."
}