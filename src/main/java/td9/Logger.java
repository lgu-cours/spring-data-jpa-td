package td9;

import org.springframework.stereotype.Component;

@Component
public class Logger {

	public Logger()
	{
		System.out.println("(+) Logger constructor");
	}
	
	public void log(String s)
	{
		System.out.println("---> LOG : " + s );
	}
}
