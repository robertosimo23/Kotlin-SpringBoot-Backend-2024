package dev.Roberto.Simoes.credit.applicationsystem


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("entity")
class CreditApplicationSystemApplication

fun main(args: Array<String>) {
    runApplication<CreditApplicationSystemApplication>(*args)
}