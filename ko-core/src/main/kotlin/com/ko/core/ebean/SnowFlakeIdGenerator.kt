package com.ko.core.ebean

import io.ebean.config.IdGenerator

class SnowFlakeIdGenerator : IdGenerator{
    private val snowFlake = SnowFlake(1,1)

    override fun nextValue(): Any {
        return snowFlake.nextId()
    }

    override fun getName(): String {
        return "SnowFlake"
    }

}
