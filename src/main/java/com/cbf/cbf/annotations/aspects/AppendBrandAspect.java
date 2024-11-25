package com.cbf.cbf.annotations.aspects;


import com.cbf.cbf.annotations.AppendBrand;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class AppendBrandAspect {

    @Around("execution(* com.cbf.cbf.controllers..*(..))") // Adjust package if needed
    public Object appendBrandToParam(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        Annotation[][] parameterAnnotations = methodSignature.getMethod().getParameterAnnotations();

        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (annotation instanceof AppendBrand appendBrand) {
                    // Modify the argument by appending the brand name
                    String brandName = appendBrand.brand();
                    args[i] = brandName + " " + args[i];
                }
            }
        }

        return joinPoint.proceed(args); // Proceed with the modified arguments
    }
}
