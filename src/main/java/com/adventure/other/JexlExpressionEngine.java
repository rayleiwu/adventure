package com.adventure.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

public class JexlExpressionEngine {



    public static void testSimpleList() {

            List<String> list = new ArrayList<String>();
            list.add("one");
            list.add("two");


            JexlContext jexlContext = new MapContext();
            jexlContext.set("list", list);;

            Map<String, Object> functions1 = new HashMap<String, Object>();
            functions1.put("system", System.out);


            JexlEngine jexl = new JexlEngine();
            jexl.setFunctions(functions1);
            Expression expression = jexl.createExpression("for(item : list) { system:println(item) }");


            expression.evaluate(jexlContext);


        }


    
}
