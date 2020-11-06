package com.bk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect//切面操作
@Component//组件扫描找到logAspect
public class logAspect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.bk.web.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String classMenthod=joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName();
        Object args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMenthod,args);
        logger.info("Request : {}  -------------deBefore---------------",requestLog);
    }

    @After("log()")
    public void doAfter(){
        logger.info("-------------doAfter---------------");
    }

    @AfterReturning(returning ="result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result:{}",result);
    }

    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object args;

        public RequestLog(String url, String ip, String classMethod, Object args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + args +
                    '}';
        }
    }
}
