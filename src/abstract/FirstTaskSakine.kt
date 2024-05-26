
/*

FIRST TASK: A Simple School System Management.


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


class Student(name: String, age: Int, val studentId: String) : SchoolMember(name, age) {
    override val role = "Student"
    private val courses: MutableList<String> = mutableListOf()

    fun enroll(course: String) {
        courses.add(course)
        println("$name has enrolled in $course")
    }

    fun listCourses() {
        println("$name is enrolled in: ${courses.joinToString(", ")}")
    }
}

// Class representing a Teacher
class Teacher(name: String, age: Int, val teacherId: String) : SchoolMember(name, age) {
    override val role = "Teacher"
    private val subjects: MutableList<String> = mutableListOf()

    fun assignSubject(subject: String) {
        subjects.add(subject)
        println("$name is now teaching $subject")
    }

    fun listSubjects() {
        println("$name teaches: ${subjects.joinToString(", ")}")
    }
}

// Class representing the School
class School(val name: String) {
    private val members: MutableList<SchoolMember> = mutableListOf()

    fun addMember(member: SchoolMember) {
        members.add(member)
        println("${member.name} has joined $name as a ${member.role}")
    }

    fun listMembers() {
        println("Members of $name:")
        for (member in members) {
            member.introduce()
        }
    }
}

fun main() {
    // Create a school
    val mySchool = School("Green Valley High")

    // Create some students and teachers
    val student1 = Student("Alice", 15, "S123")
    val student2 = Student("Bob", 17, "S124")
    val teacher1 = Teacher("Mr. Smith", 40, "T001")
    val teacher2 = Teacher("Ms. Johnson", 35, "T002")

    // Add members to the school
    mySchool.addMember(student1)
    mySchool.addMember(student2)
    mySchool.addMember(teacher1)
    mySchool.addMember(teacher2)

    // Enroll students in courses
    student1.enroll("Math")
    student1.enroll("Science")
    student2.enroll("History")

    // Assign subjects to teachers
    teacher1.assignSubject("Math")
    teacher1.assignSubject("Physics")
    teacher2.assignSubject("History")

    // List all members
    mySchool.listMembers()

    // List courses for students
    student1.listCourses()
    student2.listCourses()

    // List subjects for teachers
    teacher1.listSubjects()
    teacher2.listSubjects()
}

