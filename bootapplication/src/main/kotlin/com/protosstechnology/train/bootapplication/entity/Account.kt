package com.protosstechnology.train.bootapplication.entity

import jakarta.persistence.*

@Entity
@Table(name = "Account")
data class  Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "accountNo")
    var accountNo: Long? = null,
    @Column(name = "gender")
    var gender: String? = null,
    @Column(name = "firstName")
    var firstName: String? = null,
    @Column(name = "lastName")
    var lastName: String? = null,
    @Column(name = "age")
    var age: Int? = null,
    @Column(name = "tel")
    var tel: String? = null,
    @Column(name = "amount")
    var amount: Double? = null,


)
