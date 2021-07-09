package com.ko.starter.ebean.config

import io.ebean.config.DatabaseConfig
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("ebean")
class EbeanProperties {

    lateinit var databaseConfig: DatabaseConfig
}