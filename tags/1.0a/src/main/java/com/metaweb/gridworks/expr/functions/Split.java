package com.metaweb.gridworks.expr.functions;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.metaweb.gridworks.expr.Function;

public class Split implements Function {

	public Object call(Properties bindings, Object[] args) {
		if (args.length == 2) {
			Object v = args[0];
			Object split = args[1];
			if (v != null && split != null && split instanceof String) {
				return (v instanceof String ? (String) v : v.toString()).split((String) split);
			}
		}
		return null;
	}
	
	public void write(JSONWriter writer, Properties options)
		throws JSONException {
	
		writer.object();
		writer.key("description"); writer.value("Returns the array of strings obtained by splitting s with separator sep");
		writer.key("params"); writer.value("string s, string sep");
		writer.key("returns"); writer.value("array");
		writer.endObject();
	}
}
