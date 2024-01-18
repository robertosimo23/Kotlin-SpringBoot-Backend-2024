package dev.Roberto.Simoes.credit.applicationsystem.service.implementation

import dev.Roberto.Simoes.credit.applicationsystem.Repository.CustomerRepository
import dev.Roberto.Simoes.credit.applicationsystem.excepitons.BusinessException
import dev.Roberto.Simoes.credit.applicationsystem.service.iCustomerService
import entity.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : iCustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)


    }
}