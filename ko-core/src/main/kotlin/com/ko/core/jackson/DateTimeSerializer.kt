package com.ko.core.jackson

import cn.hutool.core.date.DateUtil
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.util.*

class DateTimeSerializer(clazz: Class<Date>) : StdDeserializer<Date>(clazz) {

    override fun deserialize(element: JsonParser?, p1: DeserializationContext?): Date {
        return DateUtil.parse(element?.valueAsString)
    }

}
