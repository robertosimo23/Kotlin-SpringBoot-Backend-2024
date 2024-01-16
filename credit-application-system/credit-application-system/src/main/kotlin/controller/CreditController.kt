package dev.Roberto.Simoes.credit.applicationsystem.controller

import com.electronwill.nightconfig.core.conversion.Path
import dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto.CreditDTO
import dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto.CreditView
import dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto.CreditViewList
import dev.Roberto.Simoes.credit.applicationsystem.service.implementation.CreditService
import entity.Credit
import jakarta.persistence.Entity
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditDTO: CreditDTO):ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit${credit.creditCode}-Customer${credit.customer?.firstName}saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
        val creditViewList:List<CreditViewList> = this.creditService.finAllByCustomer(customerId).stream().map { credit: Credit -> CreditViewList(credit) }
                .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }
    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "customerId") customerId: Long,@PathVariable creditCode:UUID):ResponseEntity<CreditView> {
        val  credit :Credit = this.creditService.finByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body( CreditView(credit))
    }
}