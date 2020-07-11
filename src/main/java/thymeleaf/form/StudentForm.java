package thymeleaf.form;

public class StudentForm {
	 
    private String Name;
    private String Classroom;
    private String id;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getClassroom() {
		return Classroom;
	}
	public void setClassroom(String classroom) {
		Classroom = classroom;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
   
}
