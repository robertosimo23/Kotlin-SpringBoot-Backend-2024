package dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto

import entity.Credit
import entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    @field:NotNull(message = "Invalid input") val creditValue:BigDecimal,
    @field:Future val dayFirstOfInstallment:LocalDate,
    @field: Min(value = 1)@field:Max(value = 48) val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid input") val customerId:Long
) {
    fun toEntity():Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id=this.customerId)
    )
}
