@file:OptIn(KtorExperimentalLocationsAPI::class)

package io.github.tuguzd.ktor_krakend.route

import io.github.tuguzd.ktor_krakend.model.Account
import io.github.tuguzd.ktor_krakend.model.toDto
import io.github.tuguzd.ktor_krakend.repository.AccountBusinessDao
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route
import org.koin.ktor.ext.inject

fun Route.business() {
    val dao by inject<AccountBusinessDao>()

    get<Accounts> {
        val accountList = dao.findAll().map(Account::toDto)
        call.respond(accountList)
    }

    get<Accounts.SearchLogin> {
        val accountList = dao.findByLogin(it.login).map(Account::toDto)
        call.respond(accountList)
    }
}
