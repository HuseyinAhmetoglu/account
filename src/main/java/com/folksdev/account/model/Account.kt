package com.folksdev.account.model

import jakarta.persistence.*
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Account(

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDHexGenerator")
        val id: String?,
        val balance: BigDecimal? = BigDecimal.ZERO,
        val creationDate: LocalDateTime,

        @ManyToOne(fetch = Fetch.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "costumer_id", nullable = false)
        val customer: Customer?,

        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
        val transaction: Set<Transaction>?
) {
        constructor() : this() {

        }
}
