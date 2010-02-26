package com.metaweb.gridworks.expr.functions;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.metaweb.gridworks.expr.Function;

public class Floor implements Function {

	public Object call(Properties bindings, Object[] args) {
		if (args.length == 1 && args[0] instanceof Number) {
			return (long) Math.floor(((Number) args[0]).doubleValue());
		}
		return null;
	}
	
	public void write(JSONWriter writer, Properties options)
		throws JSONException {
	
		writer.object();
		writer.key("description"); writer.value("Returns the floor of a number");
		writer.key("params"); writer.value("number d");
		writer.key("returns"); writer.value("number");
		writer.endObject();
	}

}
