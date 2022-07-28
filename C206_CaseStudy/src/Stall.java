import java.time.LocalDate;

// Done by Jordon - i edited a bit

public class Stall {
	private int id;
	private String name;
	private LocalDate operationDate;
	private String operationTime;
	private String category;
	private String operator;
	
	public Stall(int id, String name, LocalDate operationDate, String operationTime, 
			String category, String operator) {
		this.id = id;
		this.name = name;
		this.operationDate = operationDate;
		this.operationTime = operationTime;
		this.category = category;
		this.operator = operator;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOperationDate(LocalDate operationDate) {
		this.operationDate = operationDate;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getOperationDate() {
		return operationDate;
	}

	public String getOperationTime() {
		return operationTime;
	}

	public String getCategory() {
		return category;
	}

	public String getOperator() {
		return operator;
	}
	
	

}
