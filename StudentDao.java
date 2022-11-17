

import java.util.List;

import com.acme.document.core.persistence.document.Student;

public interface StudentDao {
	
	public List<Student> getStudentList();
	 
	public Student getStudentDetailsById(int id);
	public boolean updateStudentDetails(Student student);
	public boolean saveStudentDetails(Student student);
	public boolean deleteStudentDetails(int id);
}
