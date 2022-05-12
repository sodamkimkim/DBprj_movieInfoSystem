package movieInfo;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDto2 {

	 @NonNull
	 private int emp_no;
	 private String to_date;
	 private String dept_name;
	 private String first_name;
	 private int salary;
	 private String dept_no;
	 private String title;
	 private String gender;
	 private String birth_date;
	 private String last_name;
	 private String hire_date;
	@Override
	public String toString() {
		return "EmployeesDto2 [emp_no=" + emp_no + ", to_date=" + to_date + "\n dept_name =" + dept_name + ", first_name="
				+ first_name + ", salary=" + salary + ", dept_no=" + dept_no + ", title=" + title + ", gender=" + gender
				+ ", birth_date=" + birth_date + ", last_name=" + last_name + ", hire_date=" + hire_date + "]";
	}
	 
}
