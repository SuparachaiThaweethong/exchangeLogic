package com.protosstechnology.train.bootapplication.repository

import com.protosstechnology.train.bootapplication.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User,Long> {
    fun findByFirstnameEquals(firstname: String): User

    @Query("from User u where lower(u.firstname) like lower(concat('%', :firstname, '%'))")
    fun selectByFirstname(@Param("firstname") firstname: String): List<User>

}