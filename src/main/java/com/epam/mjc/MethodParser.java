package com.epam.mjc;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.epam.mjc.MethodSignature.*;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        int f = signatureString.indexOf("(");
        String firstHalf = String.copyValueOf(signatureString.toCharArray(),0,f);
        String secondHalf = String.copyValueOf(signatureString.toCharArray(),f+1,signatureString.length()-f-2);
        String[] signArray1 = firstHalf.split( " ");
        int mod = 0;
        MethodSignature dfg;
        System.out.println(secondHalf);
        secondHalf = secondHalf.replace(",","");
        String[] paramString = secondHalf.split( " ");

        dfg = new MethodSignature("null");

        if(secondHalf.length()!=0){
            List<Argument> params = new LinkedList<>();
            for(int i= 0;paramString.length>i;i+=2){
                params.add(new Argument(paramString[i],paramString[i+1]));
            }
            dfg = new MethodSignature("",params);

        }
        if(signatureString.contains("public")){
            dfg.setAccessModifier("public");
            mod++;
        }
        if(signatureString.contains("private")){
            dfg.setAccessModifier("private");
            mod++;
        }
        if (mod!=0){dfg.setReturnType(signArray1[1]);
        dfg.setMethodName(signArray1[2]);}
        else{dfg.setReturnType(signArray1[0]);
            dfg.setMethodName(signArray1[1]);}

        return dfg;
    }
}
