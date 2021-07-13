package com.ko.core.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.io.IOException

/**
 * javascript number 大数字处理 大于9007199254740992L 的数字全部转成字符串输出。
 * @author yuenbo
 */
open class JsNumberSerializer protected constructor() : StdSerializer<Long>(Long::class.java) {
    @Throws(IOException::class)
    override fun serialize(value: Long?, jsonGenerator: JsonGenerator, serializerProvider: SerializerProvider?) {
        //js number 最大值
        val jsMaxNum = 9007199254740992L
        if (null != value && value > jsMaxNum) {
            jsonGenerator.writeString(value.toString())
        } else {
            if (value != null) {
                jsonGenerator.writeNumber(value)
            }
        }
    }

    companion object {
        val INSTANCE = JsNumberSerializer()
    }
}
