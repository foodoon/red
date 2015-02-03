package guda.red.common.security;



import java.util.HashMap;
import java.util.Map;

/**
 * Created by foodoon on 2014/12/20.
 */
public class AppContext {


    private UserProfile userProfile;

    private Map<String,Object> attr = new HashMap<String,Object>();


    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void putAttr(String key,Object val){
        attr.put(key,val);
    }

    public Object getAttr(String key){
        return attr.get(key);
    }


}
