package com.protosstechnology.train.bootapplication.entity

import jakarta.persistence.*

@Entity
@Table(name = "TBUser")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "firstName")
    var firstname: String?= null,
    @Column(name = "lastName")
    var lastname: String?= null,
)
