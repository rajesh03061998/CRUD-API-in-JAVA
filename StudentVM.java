

public class StudentVM {
	
	
	private Integer id;
	private String name;
	private String address;
	private Long contact;

	public StudentVM() {
	}

	public StudentVM(String name, String address, Long contact) {
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	
	public StudentVM(Integer id, String name, String address, Long contact) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
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
