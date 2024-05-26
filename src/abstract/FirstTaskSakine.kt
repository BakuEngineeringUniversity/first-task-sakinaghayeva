/*


First Task: A Simple school Management
 */

interface Person {
    val name: String
    val age: Int
    fun introduce()
}

abstract class SchoolMember(override val name: String, override val age: Int) : Person {
    abstract val role: String
    override fun introduce() {
        println("Hello, my name is $name, I am $age years old and I am a $role.")
    }
}

class Student(name: String, age: Int) : SchoolMember(name, age) {
    override val role = "Student"
    private val courses: MutableList<String> = mutableListOf()

    fun enroll(course: String) {
        if (course !in courses) {
            courses.add(course)
            println("$name has enrolled in $course")
        } else {
            println("$name is already enrolled in $course")
        }
    }

    fun listCourses() {
        if (courses.isNotEmpty()) {
            println("$name is enrolled in: ${courses.joinToString(", ")}")
        } else {
            println("$name is not enrolled in any courses")
        }
    }
}

class Teacher(name: String, age: Int) : SchoolMember(name, age) {
    override val role = "Teacher"
    private val subjects: MutableList<String> = mutableListOf()

    fun assignSubject(subject: String) {
        if (subject !in subjects) {
            subjects.add(subject)
            println("$name is now teaching $subject")
        } else {
            println("$name is already teaching $subject")
        }
    }

    fun listSubjects() {
        if (subjects.isNotEmpty()) {
            println("$name teaches: ${subjects.joinToString(", ")}")
        } else {
            println("$name is not teaching any subjects")
        }
    }
}

class School(private val name: String) {
    private val members: MutableList<SchoolMember> = mutableListOf()

    fun addMember(member: SchoolMember) {
        if (member !in members) {
            members.add(member)
            println("${member.name} has joined $name as a ${member.role}")
        } else {
            println("${member.name} is already a member of $name")
        }
    }

    fun listMembers() {
        println("Members of $name:")
        if (members.isNotEmpty()) {
            for (member in members) {
                member.introduce()
            }
        } else {
            println("No members in the school")
        }
    }
}

fun main() {
    val mySchool = School("Green Valley High")

    val student1 = Student("Alice", 15)
    val student2 = Student("Bob", 17)
    val teacher1 = Teacher("Mr. Smith", 40)
    val teacher2 = Teacher("Ms. Johnson", 35)

    mySchool.addMember(student1)
    mySchool.addMember(student2)
    mySchool.addMember(teacher1)
    mySchool.addMember(teacher2)

    student1.enroll("Math")
    student1.enroll("Science")
    student2.enroll("History")

    teacher1.assignSubject("Math")
    teacher1.assignSubject("Physics")
    teacher2.assignSubject("History")

    mySchool.listMembers()


    student1.listCourses()
    student2.listCourses()

    teacher1.listSubjects()
    teacher2.listSubjects()
}
