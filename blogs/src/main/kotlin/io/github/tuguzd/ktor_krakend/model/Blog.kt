package io.github.tuguzd.ktor_krakend.model

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

data class Blog(
    @BsonId
    val id: Id<Blog>? = null,
    var name: String,
    var desc: String,
)

fun Blog.toDto() =
    BlogDto(
        id = this.id.toString(),
        name = this.name,
        desc = this.desc,
    )
