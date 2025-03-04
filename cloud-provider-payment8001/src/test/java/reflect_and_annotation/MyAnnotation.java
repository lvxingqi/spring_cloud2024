package reflect_and_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 注解在运行时保留
@Target(ElementType.METHOD) // 注解可用于方法
public @interface MyAnnotation {
    Class<?>[] clazz();
    String value() default "";
}
