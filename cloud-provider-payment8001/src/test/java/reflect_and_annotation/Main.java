package reflect_and_annotation;

import com.atguigu.cloud.entities.Pay;
import org.mybatis.spring.MyBatisSystemException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

// 使用注解
class MyClass {
    @MyAnnotation(clazz = {MyClass.class, Pay.class, MyBatisSystemException.class}, value = "haha")
    public void myMethod() {
        System.out.println("Executing myMethod");
    }
}

public class Main {
    public static void main(String[] args) {
        /*MyClass myClass = new MyClass();
        myClass.myMethod();*/

        // 使用反射处理注解
        for (Method method : MyClass.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
               /* System.out.println("全类名: " + method.getDeclaringClass().getName());
                System.out.println("方法: " + method.getName());
                System.out.println("注解value的值: " + annotation.value());*/
                Arrays.stream(annotation.clazz()).forEach(clazz -> {
                    try {
                        // 获取构造方法
                        var constructor = clazz.getDeclaredConstructor();
                        Object instance = constructor.newInstance();
                        Method[] declaredMethods = clazz.getDeclaredMethods();
                        for (Method md : declaredMethods) {
                            if (Modifier.isAbstract(md.getModifiers())|Modifier.isInterface(md.getModifiers())){
                                break;
                            }
                            ArrayList<Object> list = new ArrayList<>();
                            for (Class<?> pt : md.getParameterTypes()) {
                                if (Number.class.isAssignableFrom(clazz)){
                                    list.add(pt.getConstructor(String.class).newInstance("0"));
                                }else {
                                    list.add(pt.getConstructor().newInstance());
                                }

                            }
                            md.setAccessible(true);
                            md.invoke(instance, list.toArray());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
