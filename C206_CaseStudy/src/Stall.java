import java.time.LocalDate;

// Done by Jordon

public class Stall {
	private int id;
	private String name;
	private LocalDate operationDate;
	private String operationTime;
	private String category;
	private String operator;
	
	public Stall (int id, String name, LocalDate operationDate, String operationTime, 
			String category, String operator) {
		this.id = id;
		this.name = name;
		this.operationDate = operationDate;
		this.operationTime = operationTime;
		this.category = category;
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
