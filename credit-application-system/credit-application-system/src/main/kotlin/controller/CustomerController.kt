package dev.Roberto.Simoes.credit.applicationsystem.controller

import dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto.CustomerDTO
import dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto.CustomerUpdateDTO
import dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto.CustomerView
import dev.Roberto.Simoes.credit.applicationsystem.service.implementation.CustomerService
import entity.Customer
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomers(@RequestBody @Valid customerDTO: CustomerDTO): ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email}saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)


    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerID")
        id: Long, @RequestBody @Valid customerUpdateDTO: CustomerUpdateDTO
    ): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDTO.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))

    }
}
