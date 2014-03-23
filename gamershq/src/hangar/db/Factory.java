package hangar.db;

import org.apache.ibatis.session.SqlSession;

/**
 * @author Anderson Fagionato
 * @see closeSession()
 */
public class Factory {
	
	private SqlSession session;
	
	/**
	 * Always close a session after using it
	 */
	public void closeSession(String caller) {
		try {
			if(this.session != null){
				this.session.close();
			}
		} catch (Exception e) {
			System.out.println("Falha ao fechar conexao ibatis do " + caller);
			e.printStackTrace();
		}
	}
	
	/**
	 * Always close a session after using it
	 * no tracing
	 */
	public void closeSession(String caller, boolean console) {
		this.session.close();
	}
	
	
	/*The default openSession() method that takes no parameters will create a SqlSession with the following characteristics:
	*A transaction scope will be started (i.e. NOT auto-commit).
	*A Connection object will be acquired from the DataSource instance configured by the active environment.
	*The transaction isolation level will be the default used by the driver or data source.
	*No PreparedStatements will be reused, and no updates will be batched.	
	* - ANDERSON to use auto commit, just session = sqlSessionFactory.openSession(TRUE);
	*/
	/**
	 * 
	 * @param caller
	 * @param autoCommit
	 * @return a SqlSession. The first time it's called, the SqlSession is created, and the autoCommit is read. In subsequent calls by same object, autoCommit won't be used.
	 */
	public SqlSession getSqlSession(String caller, Boolean autoCommit) {
		if(autoCommit == null){
			autoCommit = true;
		}
		
		if(this.session == null){
			System.out.println("	- Creating SqlSession for: " + caller);
			session = FactorySingleton.getInstance().openSession(autoCommit);//true means autocommit = true
		}
		return this.session;
	}
	
	/**
	 * no console tracing
	 * @param caller
	 * @return
	 */
	public SqlSession getSqlSession(String caller, boolean console) {	
		if(this.session == null){
			session = FactorySingleton.getInstance().openSession(true);//true means autocommit = true
		}
		return this.session;
	}
}
