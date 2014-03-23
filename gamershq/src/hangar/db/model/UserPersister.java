package hangar.db.model;

import hangar.db.Foundation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson
 */
public class UserPersister extends Foundation {
	
	public void example (Integer id, String name){
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id+"");
		param.put("name", name);
		selectList("selectAllUsers", param);
	}
}
