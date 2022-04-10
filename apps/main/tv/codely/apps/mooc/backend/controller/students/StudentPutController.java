package tv.codely.apps.mooc.backend.controller.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.codely.mooc.students.application.register.RegisterStudentRequest;
import tv.codely.mooc.students.application.register.StudentRegister;

@RestController
public final class StudentPutController {
    private StudentRegister register;

    public StudentPutController(StudentRegister register) {
        this.register = register;
    }

    @PutMapping("/register-student/{id}")
    public ResponseEntity register(@PathVariable String id, @RequestBody Request request) {
        RegisterStudentRequest registerStudentRequest =
            new RegisterStudentRequest(id, request.name(), request.surname(), request.email());

        register.registerStudent(registerStudentRequest);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}

final class Request {
    private String name;
    private String surname;
    private String email;

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

