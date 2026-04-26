package com.example.demo;

	import org.springframework.web.bind.annotation.*;
	import java.util.List;

	@RestController
	@RequestMapping("/students")
	public class StudentController {

	    private final StudentRepository repo;

	    public StudentController(StudentRepository repo) {
	        this.repo = repo;
	    }

	    // CREATE
	    @PostMapping
	    public Student addStudent(@RequestBody Student student) {
	        return repo.save(student);
	    }

	    // READ
	    @GetMapping
	    public List<Student> getAllStudents() {
	        return repo.findAll();
	    }

	    // UPDATE
	    @PutMapping("/{id}")
	    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
	        student.setId(id);
	        return repo.save(student);
	    }

	    // DELETE
	    @DeleteMapping("/{id}")
	    public void deleteStudent(@PathVariable Long id) {
	        repo.deleteById(id);
	    }
	}

