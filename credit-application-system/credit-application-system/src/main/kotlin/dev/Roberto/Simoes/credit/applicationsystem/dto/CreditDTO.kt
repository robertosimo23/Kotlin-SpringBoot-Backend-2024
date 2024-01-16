package dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto

import entity.Credit
import entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    val creditValue:BigDecimal,
    val dayFirstOfInstallment:LocalDate,
    val numberOfInstallments: Int,
    val customerId:Long
) {
    fun toEntity():Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id=this.customerId)
    )
}
