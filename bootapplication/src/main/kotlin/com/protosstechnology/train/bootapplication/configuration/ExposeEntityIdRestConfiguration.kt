package com.protosstechnology.train.bootapplication.configuration

import com.protosstechnology.train.bootapplication.entity.User
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
open class ExposeEntityIdRestConfiguration : RepositoryRestConfigurer {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?, cors: CorsRegistry?) {
        config!!.exposeIdsFor(User::class.java)
    }
}