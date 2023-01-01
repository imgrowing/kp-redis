package my.ex.kpredis.repository

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "myfin:signup:student", timeToLive = 600)
class Student(
    @field: Id
    val id: String,
    var name: String,
    val gender: Gender,
    val grade: Int
) {
    enum class Gender {
        MALE, FEMALE
    }

    override fun toString(): String {
        return "Student(id='$id', name='$name', gender=$gender, grade=$grade)"
    }

}