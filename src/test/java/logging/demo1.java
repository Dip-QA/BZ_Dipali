package logging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class demo1 
{
	
	
		public static void main(String[] args) {
			
			Logger log = (Logger) LogManager.getLogger("demo1");
			
			log.info("h1");
			log.fatal("h2");
			log.debug("h3");
			log.error("h4");
			log.warn("h5");

			
			
		}

}
