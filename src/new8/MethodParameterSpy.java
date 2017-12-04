package new8;

import static java.lang.System.out;

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * JDK 8 New: Samples with ExampleMethods.java for Method Parameter Reflection.
 * @author SimonC
 * @see https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html
 * @see new8.ExampleMethods
 */
public class MethodParameterSpy {
    
    private static final String  fmt = "%24s: %s%n";
    
    //Sample class 'ExampleMethods.java' need compiling with the -parameters compiler option.
    //Eclipse to compile with the -parameters compiler option:
    //	Select the project of this -> right click -> properties -> Java compiler
    //  	-> Store information about method parameters(usable via reflection) -> OK
    public static void main(String... args) {        

        try {
            printClassConstructors(Class.forName(args[0]));
            System.out.println();
            System.out.println();
            printClassMethods(Class.forName(args[0]));
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    // for the morbidly curious
    <E extends RuntimeException> void genericThrow() throws E {}
    
    public static void printClassConstructors(Class c) {
        Constructor[] allConstructors = c.getConstructors();//only public access level
        out.format(fmt, "Number of constructors", allConstructors.length);
        for (Constructor currentConstructor : allConstructors) {
            printConstructor(currentConstructor);
        }  
        Constructor[] allDeclConst = c.getDeclaredConstructors();//all access level(public, protected, package, private)
        out.format(fmt, "Number of declared constructors",
            allDeclConst.length);
        for (Constructor currentDeclConst : allDeclConst) {
            printConstructor(currentDeclConst);
        }          
    }
    
    public static void printClassMethods(Class c) {
       Method[] allMethods = c.getDeclaredMethods();
        out.format(fmt, "Number of methods", allMethods.length);
        for (Method m : allMethods) {
            printMethod(m);
        }        
    }
    
    public static void printConstructor(Constructor c) {
        out.format("%s%n", c.toGenericString());
        Parameter[] params = c.getParameters();
        out.format(fmt, "Number of parameters", params.length);
        for (int i = 0; i < params.length; i++) {
            printParameter(params[i]);
        }
    }
    
    public static void printMethod(Method m) {
        out.format("%s%n", m.toGenericString());
        out.format(fmt, "Return type", m.getReturnType());
        out.format(fmt, "Generic return type", m.getGenericReturnType());
                
        Parameter[] params = m.getParameters();
        for (int i = 0; i < params.length; i++) {
            printParameter(params[i]);
        }
    }
    
    public static void printParameter(Parameter p) {
        out.format(fmt, "Parameter class", p.getType());
        out.format(fmt, "Parameter name", p.getName());//return the formal parameter name if compile WITH the -parameters option; return argN, where N is the index of the parameter if compile WITHOUT the -parameters option
        out.format(fmt, "Modifiers", p.getModifiers());
        out.format(fmt, "Is implicit?", p.isImplicit());
        out.format(fmt, "Is name present?", p.isNamePresent());//return true if compile WITH the -parameters option; return false if compile WITHOUT the -parameters option
        out.format(fmt, "Is synthetic?", p.isSynthetic());
    }
}
