



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student genrated by hibernate
 */
@Entity
@Table(name = "Student", catalog = "demo")

public class Student implements java.io.Serializable,BaseEntityForDocument {

	private Integer id;
	private String name;
	private String address;
	private Long contact;

	public Student() {
	}

	public Student(String name, String address, Long contact) {
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	

	public Student(Integer id, String name, String address, Long contact) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", length = 30)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "contact")
	public Long getContact() {
		return this.contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address
				+ ", contact=" + contact + "]";
	}


}
