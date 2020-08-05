package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어디에 쓸것인지
@Target(ElementType.METHOD)
//해당 애노테이션을 언제까지 유지 할것인가
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
