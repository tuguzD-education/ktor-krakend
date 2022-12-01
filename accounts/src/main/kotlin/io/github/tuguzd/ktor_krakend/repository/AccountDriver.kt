package io.github.tuguzd.ktor_krakend.repository

import com.mongodb.client.model.IndexOptions
import io.github.tuguzd.ktor_krakend.model.Account
import io.github.tuguzd.ktor_krakend.model.AccountDto
import org.litote.kmongo.KMongo
import org.litote.kmongo.ensureIndex
import org.litote.kmongo.getCollection

class AccountDriver(uri: String) {
    private val client = KMongo.createClient(uri)
    private val database = client.getDatabase("account")
    val accountCollection = database.getCollection<Account>()

    init {
        accountCollection.ensureIndex(
            properties = arrayOf(AccountDto::login),
            indexOptions = IndexOptions().unique(true)
        )
    }
}
