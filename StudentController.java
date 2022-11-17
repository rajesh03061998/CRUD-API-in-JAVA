

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.document.service.StudentService;
import com.acme.document.service.dto.StudentVM;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/getStudentlist", method = RequestMethod.GET)
	public List<StudentVM> getStudentList() {

		System.out.println("Controller---getStudentList() ");
		List<StudentVM> liststudent = studentService.getStudentList();

		if (!liststudent.isEmpty()) {
			return liststudent;
		} else {
			return null;
		}

	}

	@RequestMapping("/getStudentbyid/{id}")
	public StudentVM getStudentDetailsById(@PathVariable int id) {

		System.out.println("Controller---getStudentDetailsById() ");
		TeacherVM Studentvm = studentService.getStudentDetailsById(id);

		if (studentvm != null) {
			return studentvm;
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/updatestudentdetails", method = RequestMethod.POST)
	public String updateStudentDetails(@RequestBody StudentVM student) {

		System.out.println("Controller---updateStudentDetailsById() ");
		boolean result = StudentService.updateStudentDetails(student);

		if (result) {
			return "Student Details updated successfully";
		} else {
			return "Something wrong";

		}

	}

	@RequestMapping(value = "/savestudentdetails", method = RequestMethod.POST)
	public String saveStudentDetails(@RequestBody StudentVM student) {

		System.out.println("Controller---saveStudentDetailsById() ");

		boolean result = studentService.saveStudentDetails(teacher);

		if (result) {
			return "Student Details inserted successfully";
		} else {
			return "Something wrong";

		}

	}

	@RequestMapping("/deletestudentdetails/{id}")
	public String deleteStudentDetails(@PathVariable int id) {

		System.out.println("Controller---deleteStudentDetailsById() ");
		boolean result = studentService.deleteStudentDetails(id);

		if (result) {
			return "Student Details deleted successfully";
		} else {
			return "Something wrong";

		}

	}

}
