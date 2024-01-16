package dev.Roberto.Simoes.credit.applicationsystem.dev.Roberto.Simoes.credit.applicationsystem.dto
import java.math.BigDecimal
import entity.Address
import entity.Customer

data class CustomerDTO(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email:String,
    val password:String,
    val zipCode:String,
    val street:String
) {
  fun toEntity():Customer=Customer(
      firstName =this.firstName,
      lastName =this.lastName,
      cpf =this.cpf,
      income = this.income,
      email = this.email,
      password = this.password,
      address = Address(
          zipCode=this.zipCode,
          street=this.street
      )
  )

}
