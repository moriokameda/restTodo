package com.moriokameda.todorestapi.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.moriokameda.todorestapi.util.DateTimeUtil.DATE_FORMAT
import com.moriokameda.todorestapi.util.DateTimeUtil.DATE_TIME_FORMAT
import com.moriokameda.todorestapi.util.DateTimeUtil.TIME_FORMAT
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.format.DateTimeFormatter

@Configuration
@AutoConfigureBefore(JacksonAutoConfiguration::class)
class JacksonConfig {

    @Bean
    @Primary
    fun kotlinObjectMapper(): ObjectMapper {
        return setCommonSerializer().modules(KotlinModule.Builder().build()).build()
    }

    private fun setCommonSerializer(builder: Jackson2ObjectMapperBuilder = Jackson2ObjectMapperBuilder()): Jackson2ObjectMapperBuilder {
        return builder
            //LocalDate
            .serializers(LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
            .deserializers(LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
            // LocalDateTime
            .serializers(LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
            .deserializers(LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
            // LocalTime
            .serializers(LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT)))
            .deserializers(LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_FORMAT)))
    }
}