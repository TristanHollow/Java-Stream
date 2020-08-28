
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Mod_103_Week_2_Day_4_Act_3 {
  
    static Logger log = Logger.getLogger(Mod_103_Week_2_Day_4_Act_3.class.getName());
    public static void main(String[] args)throws ArithmeticException{
     
        try {
            System.out.println(3/0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
    //        log.debug("Hello this is a debug message");
  //    log.info("Hello this is an info message");
     log.log(Priority.ERROR, e);
        }    
    
}
    
}
