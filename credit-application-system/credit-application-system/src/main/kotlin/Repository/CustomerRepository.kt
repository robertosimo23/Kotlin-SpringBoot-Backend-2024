package dev.Roberto.Simoes.credit.applicationsystem.Repository

import entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository <Customer,Long>{
}