package br.com.Forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
class ForumApplication

fun main(args: Array<String>) {
	runApplication<ForumApplication>(*args)
}
