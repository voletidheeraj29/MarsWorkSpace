
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.emp.Employee;
import com.emp.Manager;

public class EmployeeTest
{
	public static void main(String[] args) 
	{
		try
		{
			//following line is traditional way of creating an Employee
			//Employee emp = new Employee("Amit");

			Resource resource = new FileSystemResource(".\\config\\employees.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
            Employee emp0 = (Employee) factory.getBean("employee");
            Employee emp1 = (Employee) factory.getBean("employee1");
            Employee emp2 = (Employee) factory.getBean("employee2");
            System.out.println("0"+emp0);
            System.out.println("1"+emp1);
           
            System.out.println("2"+emp2);
			/*if( emp1 == emp2   )
			{
				System.out.println("The 2 reference variables of type Employee are same.");
			}
			else
			{
				System.out.println("The 2 reference variables of type Employee are NOT same.");
			}
			if(emp1.equals(emp2))
			{
				System.out.println("The 2 employees are symantically equivalent");
			}
			else
			{
				System.out.println("The 2 employees are symantically NOT equivalent");
			}
			*/
			
			//trying to create the parent class, it will be created only if it is NOT abstract
			//BeanIsAbstractException is thrown if abstract=true for this bean definition
	//	Employee emp = (Employee) factory.getBean("employee");
			   
			Manager mgr=(Manager) factory.getBean("mgr");
			System.out.println("mgr"+mgr);

		}
		catch(BeanIsAbstractException biaexp)
		{
			biaexp.printStackTrace();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
}
