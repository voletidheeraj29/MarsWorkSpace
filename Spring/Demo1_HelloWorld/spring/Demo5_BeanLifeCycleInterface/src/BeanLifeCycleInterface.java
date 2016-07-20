 

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;


public class BeanLifeCycleInterface implements InitializingBean,DisposableBean
// BeanNameAware,BeanFactoryAware,ApplicationContextAware 
{    BeanFactory bf;
     ApplicationContext ac;
     String bn;
    private String firstname;
    int ctr=0;
	public BeanLifeCycleInterface()
	{   
		ctr++;
		System.out.println("Ctr:"+ctr);
		System.out.println("\n The Constructor of bean is called");
		
	}

	public String getFirstname() {
		return firstname;
	}

	public int getCtr() {
		return ctr;
	}

	public void init() 
	{
		ctr++;
		System.out.println("Ctr:"+ctr);
        System.out.println("\nInitializing Bean in init() method");  
    }
	public void setFirstname(String firstname)
	{
		ctr++;
		System.out.println("Ctr:"+ctr);
        System.out.println("\nInside setter setFirstname() method ");
		this.firstname = firstname;
    }

    public void setBeanName(String name)
	{    bn=name;
    	System.out.println("bean name"+name);
    	ctr++;
		System.out.println("Ctr:"+ctr);
		System.out.println("\nSetting name of a Bean in setBeanName() method ::" + name);
	}

	public void setBeanFactory(BeanFactory fac)
	{   bf=fac;
		ctr++;
		System.out.println("Ctr:"+ctr);
		System.out.println("\nSetting name of a BeanFactory in setBeanFactory() method ::" + fac);
	}

	public void setApplicationContext(ApplicationContext cntx)
	{
		ac=cntx;
		ctr++;
		System.out.println("Ctr:"+ctr);
		System.out.println("\nSetting name of a ApplicationContext in setApplicationContext() method ::" + cntx);
	}

    public void afterPropertiesSet() throws Exception
	{
    	ctr++;
		System.out.println("Ctr:"+ctr);
        System.out.println("\nInitializing Bean in afterPropertiesSet() method");      
    }
   public void  method1()
    {
    	System.out.println("beanfactory"+bf);
    	System.out.println("beanname"+bn);
    	//System.out.println("App Context"+ac);
    	
    }

    public void destroy() 
	{
    	ctr++;
		System.out.println("Ctr:"+ctr);
        System.out.println("\nDestroying Bean in destroy() method");  
    }

	public void teardown() 
	{
		ctr++;
		System.out.println("Ctr:"+ctr);
        System.out.println("\nDestroying Bean in teardown() method");  
    }

    
}






