package com.ko.starter.ebean.config

import com.ko.starter.ebean.SnowFlakeIdGenerator
import io.ebean.Database
import io.ebean.DatabaseFactory
import io.ebean.config.DatabaseConfig
import io.ebean.config.IdGenerator
import io.ebean.spring.txn.SpringJdbcTransactionManager
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Autowired




@Configuration
@EnableConfigurationProperties(EbeanProperties::class)
open class EbeanAutoConfiguration {


    @Autowired
    private val ebeanProperties: EbeanProperties? = null

    @Bean
    open fun ebeanServerFactoryBean(dataSource: DataSource): Database? {
        val config = DatabaseConfig()
        config.dataSource = dataSource
        config.externalTransactionManager = SpringJdbcTransactionManager()
        config.idGenerators = listOf<IdGenerator>(SnowFlakeIdGenerator())
        config.lazyLoadBatchSize = 100
        config.loadFromProperties()
        return DatabaseFactory.create(config)
    }
}