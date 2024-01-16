package dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto

import entity.Customer
import jakarta.validation.constraints.Email
import java.math.BigDecimal

data class CustomerUpdateDTO(
    val firstName:String,
    val lastName:String,
    val income:BigDecimal,
    val zipCode:String,
    val street:String

)
{
    fun toEntity(customer: Customer):Customer{
        customer.firstName=this.firstName
        customer.lastName=this.lastName
        customer.income=this.income
        customer.address.street=this.street
        customer.address.zipCode=this.zipCode
        return customer
    }
}
