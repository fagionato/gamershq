package hangar.db;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.ibatis.session.SqlSession;


/**
 * @author Anderson Fagionato
 */
public class Foundation {
		
	private Factory persistance;
	
	HashMap<String, Object> paramsBase;
	
	public Foundation(){
		persistance = new Factory();
		System.out.println("	+ New SqlSession: " + getClassName());
		
//		ControlBean controlBean = (ControlBean)((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("controlBean");
//		
//		if(controlBean != null){
//			paramsBase = new HashMap<String, Object>();
//			paramsBase.put("user", controlBean.getLoggedUser());
//			paramsBase.put("company", controlBean.getLoggedCompany());
//			paramsBase.put("currentTime", new Date());
//		}else{
//			paramsBase = new HashMap<String, Object>();
//		}
	}
	
	
	/* SELECTS */
	protected List<Object> selectList(String key){
		return sqlSession().selectList(key, paramsBase);
	}
	protected List<Object> selectList(Boolean autoCommit, String key){
		return sqlSession(autoCommit).selectList(key, paramsBase);
	}
	protected List<Object> selectList(String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession().selectList(key, params);
	}
	protected List<Object> selectList(Boolean autoCommit, String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession(autoCommit).selectList(key, params);
	}
	
	protected Object selectOne(String key){
		return sqlSession().selectOne(key, paramsBase);
	}
	protected Object selectOne(Boolean autoCommit, String key){
		return sqlSession(autoCommit).selectOne(key, paramsBase);
	}
	protected Object selectOne(String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession().selectOne(key, params);
	}
	protected Object selectOne(Boolean autoCommit, String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession(autoCommit).selectOne(key, params);
	}
	
	/* INSERTS */
	protected int insert(String key){
		return sqlSession().insert(key, paramsBase);
	}
	protected int insert(Boolean autoCommit, String key){
		return sqlSession(autoCommit).insert(key, paramsBase);
	}
	protected int insert(String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession().insert(key, params);
	}
	protected int insert(Boolean autoCommit, String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession(autoCommit).insert(key, params);
	}
	
	/* UPDATES */
	protected int update(String key){
		return sqlSession().update(key, paramsBase);
	}
	protected int update(Boolean autoCommit, String key){
		return sqlSession(autoCommit).update(key, paramsBase);
	}
	protected int update(String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession().update(key, params);
	}
	protected int update(Boolean autoCommit, String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession(autoCommit).update(key, params);
	}
	
	/* DELETES */
	protected int delete(String key){
		return sqlSession().delete(key, paramsBase);
	}
	protected int delete(Boolean autoCommit, String key){
		return sqlSession(autoCommit).delete(key, paramsBase);
	}
	protected int delete(String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession().delete(key, params);
	}
	protected int delete(Boolean autoCommit, String key, Object param){
		HashMap<String, Object> params = SerializationUtils.clone(paramsBase);
		params.put("param", param);
		return sqlSession(autoCommit).delete(key, params);
	}
	
	protected void rollback(){
		sqlSession(false).rollback();
	}
	
	protected void commit(){
		sqlSession(false).commit();
	}
	
	
	/**
	 * no console tracing
	 * @param console
	 */
	public Foundation(boolean console){
		persistance = new Factory();
	}
	
	/**
	 * Always close a session after using it, and always close using this method
	 */
	public void closeSession(){
		this.persistance.closeSession(getClassName());
	}
	
	/**
	 * Always close a session after using it, and always close using this method
	 * No console tracing provided
	 */
	public void closeSession(boolean console){
		this.persistance.closeSession(getClassName(), console);
	}
	
	/**
	 * 
	 * @param autoCommit
	 * @return
	 */
	private SqlSession sqlSession(Boolean autoCommit){
		return this.persistance.getSqlSession(getClassName(), autoCommit);
	}
	
	/**
	 * Auto Commit = TRUE
	 * @return
	 */
	private SqlSession sqlSession(){
		return this.persistance.getSqlSession(getClassName(), true);
	}
	
	/* coisas do log do reactioncam
	/**
	 * No console tracing provided
	 * @return
	 *
	public SqlSession getSqlSession(boolean console){
		return this.persistance.getSqlSession(getClassName(), console);
	}*/
	
	private String getClassName(){
		return this.getClass().toString().substring(this.getClass().toString().lastIndexOf(".")+1);
	}
}
