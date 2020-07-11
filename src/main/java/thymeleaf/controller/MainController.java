package thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import thymeleaf.form.StudentForm;
import thymeleaf.model.Student;



@Controller
public class MainController {
 
    private static List<Student> stu = new ArrayList<Student>();
 
    static {
    	
        stu.add(new Student("SV01","Teo", "UD14310"));
        stu.add(new Student("SV02","Ti", "UD14306"));
    }
 
   
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("message", message);
 
        return "index";
    }
 
    @RequestMapping(value = { "/studentList" }, method = RequestMethod.GET)
    public String studentList(Model model) {
    	
        model.addAttribute("stu", stu);
 
        return "studentList";
    }
 
    @RequestMapping(value = { "/addStudent" }, method = RequestMethod.GET)
    public String showAddStudentPage(Model model) {
 
        StudentForm stuForm = new StudentForm();
        model.addAttribute("stuForm", stuForm);
 
        return "addStudent";
    }
 
  
    @RequestMapping(value = { "/addStudent" }, method = RequestMethod.POST)
    public String saveStudent(Model model, //
            @ModelAttribute("stuForm") StudentForm stuForm) {
 
        String id = stuForm.getId();
        String Name = stuForm.getName();
        String Classroom= stuForm.getClassroom();
        
        if (id != null && id.length() > 0 //
                && Name != null && Name.length() > 0 
        		&& Classroom !=null && Classroom.length() > 0) {
            Student newStudent = new Student(id,Name, Classroom);
            stu.add(newStudent);
 
            return "redirect:/studentList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "addStudent";
    }
//    @RequestMapping(value = { "/updatePerson,{/id}" }, method = RequestMethod.POST)
//    public String updatePerson(Model model, //
//            @ModelAttribute("personForm") PersonForm personForm) {
//    	
//    	String id = null;
//    	personForm.setId(id);
//		String firstName=null;
//		personForm.setFirstName(firstName);
//		String lastName = null;
//		personForm.setLastName(lastName);
//	
//        
// 
//        if (firstName != null && firstName.length() > 0 //
//                && lastName != null && lastName.length() > 0) {
//            Person newPerson = new Person(id,firstName, lastName);
//           
// 
//            return "redirect:/personList";
//        }
// 
//        model.addAttribute("errorMessage", errorMessage);
//        return "addPerson";
//    }
//    
//    @RequestMapping("/deletePerson/{id}")
//    public String deletePerson(@PathVariable("id") String id, Model model,
//    		@ModelAttribute("personForm") PersonForm personForm) {
//    		persons.remove(persons.get(0));
//    	
//      
//      return "redirect:/personList";
//    }
 
}