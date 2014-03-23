package hangar.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Anderson Fagionato
 *
 */
public class FactorySingleton {
	
	private SqlSessionFactory sqlSessionFactory;
	
	
    // Private constructor prevents instantiation from other classes
    private FactorySingleton() { 
    	String resource = "hangar/db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			System.out.println("NEW SINGLETON SqlSessionFactory: FactorySingleton (it it appears more than once, it is a bug)");
			
//			FacesContext facesContext = FacesContext.getCurrentInstance();
//			if (facesContext.isProjectStage(ProjectStage.Production)) {
			    System.out.println("Initializing DB in Production mode");
			    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "rds-production");//rds cloudbees
//			}else{
//				if (facesContext.isProjectStage(ProjectStage.Development)) {
//					System.out.println("Initializing DB in Development mode");
//					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "local");
//				}
//			}
		} catch (IOException e) {
			System.out.println("***REC*** FactorySingleton - cannot read the connection descriptor to create a new SqlSessionFactory");
			e.printStackTrace();
		}
    }

    /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class SingletonHolder { 
            public static final FactorySingleton INSTANCE = new FactorySingleton();
    }

    public static SqlSessionFactory getInstance() {
            return SingletonHolder.INSTANCE.sqlSessionFactory;
    }
}