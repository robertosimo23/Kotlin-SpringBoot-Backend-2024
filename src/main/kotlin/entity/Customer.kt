package entity

import entity.Address
import entity.Credit
import java.math.BigDecimal

data class Customer(
    var firstName :String = "",
    var lastName : String = "",
    val cpf : String= " ",
    var email: String = " ",
    var address: Address = Address(),
    var income : BigDecimal,
    var credits: List<Credit> = mutableListOf(),
    val id: Long? = null,
    val password:String=""
)
