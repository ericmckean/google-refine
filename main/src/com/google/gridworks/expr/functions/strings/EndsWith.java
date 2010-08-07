package com.google.gridworks.expr.functions.strings;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.google.gridworks.expr.EvalError;
import com.google.gridworks.gel.ControlFunctionRegistry;
import com.google.gridworks.gel.Function;

public class EndsWith implements Function {

    public Object call(Properties bindings, Object[] args) {
        if (args.length == 2) {
            Object s1 = args[0];
            Object s2 = args[1];
            if (s1 != null && s2 != null && s1 instanceof String && s2 instanceof String) {
                return ((String) s1).endsWith((String) s2);
            }
        }
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects 2 strings");
    }

    public void write(JSONWriter writer, Properties options)
        throws JSONException {
    
        writer.object();
        writer.key("description"); writer.value("Returns whether s ends with sub");
        writer.key("params"); writer.value("string s, string sub");
        writer.key("returns"); writer.value("boolean");
        writer.endObject();
    }
}