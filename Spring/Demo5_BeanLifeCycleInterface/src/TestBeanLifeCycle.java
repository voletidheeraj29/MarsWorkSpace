

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

class TestBeanLifeCycle 
{
	public static void main(String[] args) throws Exception 
	{
       Resource resource = new FileSystemResource(".\\config\\beans.xml");
	BeanFactory factory = new XmlBeanFactory(resource);

      // after calling getBean(), the container is going to create the bean.
		//this is known as lazy loading
      BeanLifeCycleInterface beanlife = (BeanLifeCycleInterface)factory.getBean("MyBean");
        
		//ApplicationContext context = new FileSystemXmlApplicationContext(".\\config\\beans.xml");
	//	BeanLifeCycleInterface beanlife = (BeanLifeCycleInterface)context.getBean("MyBean");
		//Bean2 beanlife1 = (Bean2)context.getBean("b2");
		beanlife.method1();
		System.out.println(beanlife.getFirstname());
        beanlife=null;
		//System.out.println("Calling destroySingletons()");
      //  ( (DefaultSingletonBeanRegistry) factory).destroySingletons();
      //  System.out.println("Finished destroySingletons()");
    }
}
