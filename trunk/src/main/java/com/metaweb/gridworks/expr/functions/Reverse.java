package com.metaweb.gridworks.expr.functions;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.metaweb.gridworks.expr.ControlFunctionRegistry;
import com.metaweb.gridworks.expr.Function;
import com.metaweb.gridworks.expr.EvalError;

public class Reverse implements Function {

	public Object call(Properties bindings, Object[] args) {
		if (args.length == 1) {
			Object v = args[0];
			
			if (v != null && v.getClass().isArray()) {
				Object[] a = (Object[]) v;
				Object[] r = new Object[a.length];
				
				for (int i = 0; i < a.length; i++) {
					r[i] = a[r.length - i - 1];
				}
				
				return r;
			}
		}
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects an array");
	}

	public void write(JSONWriter writer, Properties options)
		throws JSONException {
	
		writer.object();
		writer.key("description"); writer.value("Reverses array a");
		writer.key("params"); writer.value("array a");
		writer.key("returns"); writer.value("array");
		writer.endObject();
	}
}
