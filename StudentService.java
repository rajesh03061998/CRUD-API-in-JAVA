

import java.util.List;

import com.acme.document.core.persistence.document.Student;
import com.acme.document.service.dto.StudentVM;

public interface StudentService {
	
	public List<StudentVM> getStudentList();
	 
	public StudentVM getStudentDetailsById(int id);
	public boolean updateStudentDetails(StudentVM student);
	public boolean saveStudentDetails(StudentVM student);
	public boolean deleteStudentDetails(int id);

}
