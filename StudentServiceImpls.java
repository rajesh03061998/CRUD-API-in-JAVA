

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.document.core.persistence.document.Student;
import com.acme.document.data.model.StudentDao;
import com.acme.document.service.dto.StudentVM;

@Service
public class StudentServiceImpls implements StudentService{
	
@Autowired
	StudentDao StudentDao;
	@Override
	public List<StudentVM> getStudentList() {
		
		List<StudentVM> liststudentvm=new ArrayList<StudentVM>();
		System.out.println("Service---getStudentList() ");
		
		List<Student> liststudent=studentDao.getStudentList();
		
		for(Student student:liststudent)
		{
			
			
			
			
			StudentVM studentvm=new StudentVM(student.getId(), student.getName(), student.getAddress(), student.getContact());
			liststudentvm.add(studentvm);
			
		}
		
		if(!liststudentvm.isEmpty())
		{
			
			return liststudentvm;
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public StudentVM getStudentDetailsById(int id) {
		
		System.out.println("Service---getStudentDetailsById() ");
		Student student=studentDao.getStudentDetailsById(id);
		StudentVM studentvm=new StudentVM(student.getId(), student.getName(), student.getAddress(), student.getContact());
		if(studentvm!=null)
		{
			return studentvm;
			
			
		}
		else
		{
		return null;
		}
	}

	@Override
	public boolean updateStudentDetails(StudentVM studentVM) {
		
		System.out.println("Service---updateStudentDetails() ");
		
		Student student =new Student(studentVM.getId(), studentVM.getName(), studentVM.getAddress(), studentVM.getContact());
		
		boolean result=studentDao.updateStudentDetails(student);
		if(result)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public boolean saveStudentDetails(StudentVM studentVM) {
		
		System.out.println("Service---saveStudentDetails() ");
         Student student =new Student(studentVM.getId(), studentVM.getName(), studentVM.getAddress(), studentVM.getContact());
		
		boolean result=studentDao.saveStudentDetails(student);
		if(result)
		{
			return true;
			
		}
		else
		{ 
			return false;
		}
	}

	@Override
	public boolean deleteStudentDetails(int id) {
   
		System.out.println("Service---deleteStudentDetails() ");
		boolean result=studentDao.deleteStudentDetails(id);
		if(result)
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}

}
