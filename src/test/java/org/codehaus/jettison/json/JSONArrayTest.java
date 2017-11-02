package org.codehaus.jettison.json;

import org.junit.Test;

import junit.framework.TestCase;

public class JSONArrayTest extends TestCase {
    public void testInvalidArraySequence() throws Exception {
    	try {
    	    new JSONArray("[32,");
    	    fail("Exception expected");
    	} catch (JSONException ex) {
    		assertTrue(ex.getMessage().startsWith("JSONArray text has a trailing ','"));
    	}
    }
    
    public void testInvalidArraySequence2() throws Exception {
    	try {
    	    new JSONArray("[32,34");
    	    fail("Exception expected");
    	} catch (JSONException ex) {
    		assertTrue(ex.getMessage().startsWith("Expected a ',' or ']'"));
    	}
    }
    
    @Test
    public void testIterator() {
    		JSONArray a = new JSONArray();
    		a.put(1).put(2).put(3);
    		for(Object aa:a) {
    			System.out.println(aa);
    		}
    }
    
    @Test
    public void testTypedJSONArrayIterator() {
    		TypedJSONArray<Integer> a = new TypedJSONArray<Integer>();
    		a.put(1).put(2).put(3);
    		for(Integer aa:a) {
    			System.out.println(aa);
    		}
    		
    		TypedJSONArray<JSONObject> b = new TypedJSONArray<JSONObject>();
    		for(int i=0;i<5;i++) b.put(new JSONObject().put("key", i));
    		
    		for(JSONObject bb:b) {
    			System.out.println(bb.toString(4));
    		}
    }
}
