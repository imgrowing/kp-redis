package my.ex.kpredis

import my.ex.kpredis.repository.Student
import my.ex.kpredis.repository.StudentRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class RedisCommandLineRunner(
    private val studentRepository: StudentRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val id = "eng_2015_001"
        var student = Student(id, "John Doe", Student.Gender.MALE, 1)
        studentRepository.save(student)

        student = studentRepository.findById(id).get()
        log.warn("retrievedStudent1: $student")

        val student2 = Student("eng_2014_012", "Hong gil dong", Student.Gender.MALE, 2)
        studentRepository.save(student2)
        val count = studentRepository.findAll().count()
        log.warn("total count: $count")


        student.name = "Richard Watson"
        studentRepository.save(student)

        student = studentRepository.findById(id).get()
        log.warn("retrievedStudent2: $student")

        studentRepository.deleteById(id)
        val isPresent = studentRepository.findById(id).isPresent
        log.warn("retrievedStudent3 is present: $isPresent")

        studentRepository.deleteById(student2.id)
    }

    private val log = LoggerFactory.getLogger(this::class.java)
}