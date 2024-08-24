package me.choicore.samples.parking.common.configuration.jpa

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EntityScan(basePackages = ["me.choicore.samples.parking"])
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["me.choicore.samples.parking"])
@EnableTransactionManagement
@Configuration(proxyBeanMethods = false)
class JpaConfiguration
