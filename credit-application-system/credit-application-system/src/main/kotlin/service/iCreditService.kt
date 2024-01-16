package dev.Roberto.Simoes.credit.applicationsystem.service

import entity.Credit
import java.util.UUID

interface iCreditService {
    fun save (credit:Credit):Credit
    fun finAllByCustomer(customerId: Long):List<Credit>
    fun finByCreditCode(customerId: Long,creditCode: UUID): Credit
}