package thymeleaf.model;
 
public class Student {
 
    private String Name;
    private String Classroom;
    private String id;
 
    public Student() {
 
    }
 
    public Student(String id,String Name , String Classroom) {
        this.id=id;
    	this.Name= Name;
    	this.Classroom= Classroom;
    }
 
    public String getId() {
		return id;
	}

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

	public void setId(String id) {
		this.id = id;
	}

	
 
}