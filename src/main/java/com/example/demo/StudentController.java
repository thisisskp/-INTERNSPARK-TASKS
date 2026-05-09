package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	import org.springframework.web.bind.annotation.*;
	import java.util.List;

	@RestController
	@RequestMapping("/students")
	public class StudentController {
		private static final Logger logger =
				LoggerFactory.getLogger(StudentController.class);
	    private final StudentRepository repo;

	    public StudentController(StudentRepository repo) {
	        this.repo = repo;
	    }

	    // CREATE
	    @PostMapping
	    public Student addStudent(@RequestBody Student student) {
	    	logger.info("Adding student");
	        return repo.save(student);
	    }

	    // READ
	    @GetMapping
	    public List<Student> getAllStudents() {
	    	logger.info("Fetching all students");
	    	
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

