package springdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import springdemo.entity.Student;
import springdemo.exception.StudentNullException;
import springdemo.service.GeneralService;
import springdemo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    @Qualifier(value = "studentService")
//    TODO search for the reason, why GeneralService works but StudentService throws an exception?
    private GeneralService generalService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return generalService.getListServ();

    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        Student student = (Student) generalService.getServ(studentId);
        if (student == null) {
            throw new StudentNullException(" Student does not exist " + studentId);
        }
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        generalService.saveServ(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        generalService.saveServ(student);
        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId) {
        Student student = (Student) generalService.getServ(studentId);
        if (student == null) {
            throw new StudentNullException(" Student does not exist " + studentId);
        }
        generalService.deleteServ(student);
        return "Deleted student id - "+studentId;
    }
}
