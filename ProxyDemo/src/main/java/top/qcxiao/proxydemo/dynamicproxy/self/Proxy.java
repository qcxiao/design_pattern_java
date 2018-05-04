package top.qcxiao.proxydemo.dynamicproxy.self;

import javax.tools.ToolProvider;
import java.io.FileWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
    /**
     * @param subject           被代理类的接口的Class对象
     * @param invocationHandler 代理类的接口
     * @return
     * @throws Exception
     */
    public static Object newProxyInstance(Class subject, InvocationHandler invocationHandler) throws Exception {
        String methodStr = "";
        String rt = "\r\n";
        // 代理类与被代理放在同一个包下，所以这里直接使用相同包名即可
        String packageName = subject.getPackage().getName();

        /**
         * 利用反射得到subject的所有方法，并重新组装
         */
        Method[] methods = subject.getMethods();
        for (Method method : methods) {
            // 方法表参数类型以及参数
            Parameter[] parameters = method.getParameters();
            // 参数表
            StringBuilder parameterStr = new StringBuilder();

            // class.getMethod时所需要的参数类型表
            StringBuilder parameterTypeStr = new StringBuilder(",");

            // invoke时所需要的参数名称
            StringBuilder parameterNameStr = new StringBuilder(",");

            // 遍历所有参数
            for (Parameter parameter : parameters) {
                parameterStr.append(parameter.getType().getName() + " " + parameter.getName() + ",");
                parameterTypeStr.append(parameter.getType().getName() + ".class,");
                parameterNameStr.append(parameter.getName() + ",");
            }
            parameterStr = parameterStr.length() == 0 ? new StringBuilder() : parameterStr.deleteCharAt(parameterStr.length() - 1);
            parameterTypeStr = parameterTypeStr.length() == 1 ? new StringBuilder() : parameterTypeStr.deleteCharAt(parameterTypeStr.length() - 1);
            parameterNameStr = parameterNameStr.length() == 1 ? new StringBuilder() : parameterNameStr.deleteCharAt(parameterNameStr.length() - 1);
            methodStr += "    @Override" + rt +
                    "    public  " + method.getReturnType() + " " + method.getName() + "(" + parameterStr + ") {" + rt +
                    "        try {" + rt +
                    "           Method method = " + subject.getName() +
                    "           .class.getMethod(\"" + method.getName() + "\"" +
                    parameterTypeStr + ");" + rt +
                    "           invocationHandler.invoke(method" + parameterNameStr + ");" + rt +
                    "        }catch(Exception e) {" +
                    "           e.printStackTrace();" +
                    "        }" + rt +
                    "    }" + rt;
        }

        /**
         * 生成Java源文件
         */
        String srcCode =
                "package " + packageName + ";" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "public class $Proxy1 implements " + subject.getName() + "{" + rt +
                        "    " + packageName + ".InvocationHandler invocationHandler;" + rt +
                        "    public $Proxy1(InvocationHandler invocationHandler) {" + rt +
                        "        this.invocationHandler = invocationHandler;" + rt +
                        "    }" + rt + methodStr + rt +
                        "}";
        String fileName =
                "/Users/qcxiao/like/Design_pattern_java/ProxyDemo/target/classes/top/qcxiao/proxydemo/dynamicproxy/self/$Proxy1.java";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(srcCode);
        fileWriter.flush();
        fileWriter.close();

        /**
         * 将Java文件编译成class文件
         */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardJavaFileManager =
                compiler.getStandardFileManager(null, null, null);
        Iterable iterable = standardJavaFileManager.getJavaFileObjects(fileName);

        CompilationTask compilationTask =
                compiler.getTask(null, standardJavaFileManager,
                        null, null, null, iterable);
        compilationTask.call();
        standardJavaFileManager.close();

        /**
         * 装载到内存，并实例化
         */
        // 装载，以下两种方式可以装载
        //Class clazz = Proxy.class.getClassLoader().loadClass(packageName + ".$Proxy1");
        Class clazz = Class.forName(packageName + ".$Proxy1");
        // 通过构造函数初始化类
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        Object object = constructor.newInstance(invocationHandler);

        return object;
    }
}
