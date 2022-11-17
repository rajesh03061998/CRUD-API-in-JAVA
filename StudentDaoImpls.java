

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acme.common.core.constant.TransactionManager;
import com.acme.document.core.persistence.document.Student;
import com.acme.document.data.repository.DocumentDataRepository;


@Repository
public class StudentDaoImpls implements StudentDao{
	
	@Autowired
	DocumentDataRepository documentDataRepository;

	@Override
	@Transactional(value = TransactionManager.FOR_DOCUMENT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly=false)
	public List<Student> getStudentList() {
		System.out.println("Dao:getStudentList()");
		
		//List<Student> liststudent=documentDataRepository.getAll(Student.class);
		
		List<Student> liststudent=documentDataRepository.createCriteria(Student.class).list();
		
		if(!liststudent.isEmpty())
		{
			return liststudent;
			
		}
		else{
			
		   return null;
		
		}
	}
		
		

	@Override
	@Transactional(value = TransactionManager.FOR_DOCUMENT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly=false)
	public Student getStudentDetailsById(int id) {
		
		System.out.println("Dao: getStudentDetailsById()");

	//Student student=documentDataRepository.getById(Student.class, id);
		Query query=documentDataRepository.createQuery("from Student where id=:id");
		query.setParameter("id", id);
		Student student=(Student) query.uniqueResult(); 
		
		if(student!=null)
		{
			return student;
			
		}
		else
		{
		    return null;
	
		}
	}
	@Override
	@Transactional(value = TransactionManager.FOR_DOCUMENT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly=false)
	public boolean updateStudentDetails(Student student) {
		
		System.out.println("Dao: updateStudentDetails()");
		//Student student1=documentDataRepository.update(student);
		
		Query query=documentDataRepository.createQuery("update Student set name=:name,address=:address,contact=:contact where id=:id");
		
		query.setParameter("name",student.getName());
		query.setParameter("address",student.getAddress());
		query.setParameter("contact",student.getContact());
		query.setParameter("id",student.getId());
		
		int i=query.executeUpdate();
		
		if(i>0)
		{
			
			return true;
		}
		else
		{
		   return false;
		}
		
		/*if(student1!=null)
		{
			
			return true;
		}
		else
		{
		   return false;
		}*/
	}

	@Override
	@Transactional(value = TransactionManager.FOR_DOCUMENT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly=false)
	public boolean saveStudentDetails(Student student) {
		
		System.out.println("Dao: saveStudentDetails()");
/*Student student=documentDataRepository.save(student);
		
		if(student1!=null)
		{
			
			return true;
		}
		else
		{
		   return false;
		}*/
		
Query query=documentDataRepository.createSQLQuery("insert into student(name,address,contact) values(:name,:address,:contact)");
		
		query.setParameter("name",student.getName());
		query.setParameter("address",student.getAddress());
		query.setParameter("contact",student.getContact());
		int i=query.executeUpdate();
		
		if(i>0)
		{
		
			return true;
		}
		else
		{
		   return false;
		}
		
		
		
	}

	@Override
	@Transactional(value = TransactionManager.FOR_DOCUMENT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly=false)
	public boolean deleteStudentDetails(int id) {
		System.out.println("Dao: deleteStudentDetails()");
		
		/*Student student=getStudentDetailsById(id);
		
         documentDataRepository.delete(student);
		
		return true;*/
		
		Query query=documentDataRepository.createQuery("delete from Student where id=:id");
		
		query.setParameter("id",id);
         int i=query.executeUpdate();
		
		if(i>0)
		{
		
			return true;
		}
		else
		{
		   return false;
		}
		
		
		
	}

}
