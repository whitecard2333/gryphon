package com.oraclecube.whitecard.aop;

import com.oraclecube.whitecard.model.response.JsonResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Provides advices for Controller aspect
 * Created by zhouhu on 17/4/2017.
 */
@Component
@Aspect
@Order(12)
public class ControllerAspect extends AbstractAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * aroundAdvice supports:
     * 1. log for all of controller methods with Annotation {@link ResponseBody}
     * 2. add some property into {@link JsonResponse}, e.g. timestamp and duration
     * @param proceedingJoinPoint
     * @param anno
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* com.oraclecube.whitecard.controller.*.*(..)) && @annotation(anno)")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, ResponseBody anno) throws Throwable {
        if (null == proceedingJoinPoint) {
            return null;
        }
        String targetClassName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String targetMethodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        logger.info("aroundAdvice | {} | {}", targetClassName, targetMethodName);
        long start = System.currentTimeMillis();
        Object response;
        try {
            response = proceedingJoinPoint.proceed(args);
            long end = System.currentTimeMillis();
            if (response instanceof JsonResponse) {
                JsonResponse res = (JsonResponse) response;
                res.setTimestatmp(start);
                res.setDuration(end - start);
            }
        } catch (Throwable throwable) {
            logger.error("aroundAdvice | {} | {} encounters some throwable", targetClassName, targetMethodName, throwable);
            throw throwable;
        }
        return response;
    }
}
