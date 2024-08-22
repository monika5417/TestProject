package com.TestMapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TestMapping.entity.Department;
import com.TestMapping.entity.Laptop;
import com.TestMapping.entity.Mission;
import com.TestMapping.entity.Student;
import com.TestMapping.repository.DepartmentRepository;
import com.TestMapping.repository.LaptopRepository;
import com.TestMapping.repository.MissionRepostiory;
import com.TestMapping.repository.StudentRepository;

@RestController
public class StudentDataController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private MissionRepostiory missionRepostiory;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
//		  Laptop lap = new Laptop();
//		    lap.setlName(student.getLaptop().getlName());
//
//		    
//		    // Save the Laptop first to ensure it has an ID
//		    Laptop savedLaptop = laptopRepository.save(lap);
//
//		    Department depa = new Department();
//		    depa.setdName(student.getDepartment().getdName());
//		    
//		    Department save = departmentRepository.save(depa);
//		    
//		    // Associate the saved Laptop with the Student
//		    student.setLaptop(savedLaptop);
//		    student.setDepartment(save);
//
//		    // Now save the Student
//		    Student savedStudent = studentRepository.save(student);
//
//		    // Update the Laptop to set the back reference to the saved Student
//		    savedLaptop.setStudent(savedStudent);
//		    laptopRepository.save(savedLaptop);
		
		
		
		
		
		  Department department = student.getDepartment();
		    if (department != null && department.getdId() == null) {
		        department = departmentRepository.save(department);
		    }
		    student.setDepartment(department);

		    // Save the missions if they're not already saved
		    List<Mission> missions = student.getMission();
		    if (missions != null) {
		        for (int i = 0; i < missions.size(); i++) {
		            Mission mission = missions.get(i);
		            if (mission.getId() == null) {
		                mission = missionRepostiory.save(mission);
		            }
		            missions.set(i, mission);
		        }
		    }
		    student.setMission(missions);

		    // Save the student first
		    Student savedStudent = studentRepository.save(student);

		    // Save the laptop and link it to the saved student
		    Laptop laptop = student.getLaptop();
		    if (laptop != null) {
		        laptop.setStudent(savedStudent); // Link to the saved student
		        laptop = laptopRepository.save(laptop);
		        savedStudent.setLaptop(laptop);
		    }

		    // Finally, save the student again to persist the laptop relationship
		    return studentRepository.save(savedStudent);
		
	}
	
	@GetMapping("/{id}")
	public Student getStudentData(@PathVariable Long id) {
//		return laptopRepository.findById(id).get();
		return studentRepository.findById(id).get();
	} 
	
}
