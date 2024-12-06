package com.ammar.ishfaq.drugs.models.base


data class ResponseError(
   var statusCode: Int? = null,
   var message: String? = null

) : java.io.Serializable