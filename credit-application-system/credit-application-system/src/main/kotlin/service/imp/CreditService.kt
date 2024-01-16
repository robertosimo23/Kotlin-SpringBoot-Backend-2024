package dev.Roberto.Simoes.credit.applicationsystem.service.implementation

import dev.Roberto.Simoes.credit.applicationsystem.Repository.CreditRepository
import entity.Credit
import org.springframework.stereotype.Service
import java.util.*
import dev.Roberto.Simoes.credit.applicationsystem.service.iCreditService as iCreditService

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : iCreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }
    override fun finAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun finByCreditCode(customerId: Long,creditCode: UUID): Credit {
       val credit:Credit = (this.creditRepository.findByCreditCode(creditCode)
           ?:throw RuntimeException("Creditcode $creditCode not found"))
        return if (credit.customer?.id == customerId)credit else throw RuntimeException("Contact admin")
    }
}