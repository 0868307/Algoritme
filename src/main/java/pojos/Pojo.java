package pojos;

import java.util.HashMap;

/**
 * Created by Wouter on 1/26/2015.
 */
public abstract class Pojo {
    protected HashMap<String, Object> attributes = new HashMap<String,Object>();
    public Pojo()
    {}

    public String getString(String key)
    {
        if(attributes.get(key) instanceof String)
        {
            return (String) attributes.get(key);
        }
        return null;
    }
    public Integer getInteger(String key)
    {
        if(attributes.get(key) instanceof Integer)
        {
            return (Integer) attributes.get(key);
        }
        return null;
    }


}
