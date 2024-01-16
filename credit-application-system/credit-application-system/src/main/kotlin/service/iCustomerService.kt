package dev.Roberto.Simoes.credit.applicationsystem.service

import entity.Customer

interface iCustomerService {
    fun save (customer: Customer):Customer
    fun findById(id:Long): Customer
    fun delete(id: Long)





}