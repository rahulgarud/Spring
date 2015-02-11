import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import edu.aspire.beans.GreetingService;

public class HelloApp {
	public static void main(String[] args) {
		// Spring Container
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"spring_hello/applicationContext.xml"));
		//Spring Framework
		/*ApplicationContext factory = new ClassPathXmlApplicationContext(
		"applicationContext.xml");*/
		GreetingService gs1 = (GreetingService) factory.getBean("gs1");
		gs1.sayGreeting();

		GreetingService gs2 = (GreetingService) factory.getBean("gs2");
		gs2.sayGreeting();
	}
}
