package dev.Roberto.Simoes.credit.applicationsystem.excepitons

import java.lang.Exception
import java.time.LocalDateTime

data class ExceptionDetails (
    val title :String,
    val timestmap:LocalDateTime,
    val status :Int ,
    val exception: String,
    val details: MutableMap<String,String?>
)
{
}