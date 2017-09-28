/** 
 * @author Shivam
 * @version 1.0
 * @Date 29-August-2017
 * @project Data Structure Assignment 6
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class NaturalSortingTest {
	static List<Employee> empList;
	String result = "", expected = "";

	@BeforeClass
	public static void setup(){
		empList = new ArrayList<Employee>();
		empList.add(new Employee("Neel", "Jaipur"));
		empList.add(new Employee("Shivam", "Gwalior"));
		empList.add(new Employee("Udit", "Jabalpur"));
		empList.add(new Employee("Prateek", "Datia"));
		empList.add(new Employee("Gaurav", "Sirohi"));
	}

	//Posititve Test-case
	@Test
	public void TestPosititve(){
		Collections.sort(empList);
		result = empList.toString();
		expected = "[\n0  Neel Jaipur , \n1  Shivam Gwalior , \n2  Udit Jabalpur , \n3  Prateek Datia , \n4  Gaurav Sirohi ]";
		assertEquals(expected, result);
	}

	//Negative Test-case
	@Test
	public void TestNegative(){
		Collections.sort(empList);
		result = empList.toString();
		expected = "[\n2  Udit Jabalpur , \n1  Shivam Gwalior , \n3  Neel Jaipur , \n3  Prateek Datia , \n4  Gaurav Sirohi ]";
		assertFalse(expected.equals(result));
	}
}
