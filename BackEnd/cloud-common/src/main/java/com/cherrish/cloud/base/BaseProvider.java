package com.cherrish.cloud.base;

import com.alibaba.fastjson.JSON;
import com.cherrish.cloud.Constants;
import com.cherrish.cloud.util.InstanceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author ccl
 * @time 2018-01-31 13:44
 * @name BaseProvider
 * @desc:
 */
@Slf4j
public abstract class BaseProvider implements ApplicationContextAware{
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Parameter execute(Parameter parameter) {
        String no = parameter.getNo();
        log.info("{} request：{}", no, JSON.toJSONString(parameter));
        Object service = applicationContext.getBean(parameter.getService());
        try {
            String method = parameter.getMethod();
            Object[] param = parameter.getParam();
            Object result = InstanceUtil.invokeMethod(service, method, param);
            Parameter response = new Parameter(result);
            log.info("{} response：{}", no, JSON.toJSONString(response));
            return response;
        } catch (Exception e) {
            log.error(no + " " + Constants.Exception_Head, e);
            throw e;
        }
    }

    public Object execute(String service, String method, Object... parameters) {
        log.info("{}.{} request：{}", service, method, JSON.toJSONString(parameters));
        Object owner = applicationContext.getBean(service);
        try {
            Object result = InstanceUtil.invokeMethod(owner, method, parameters);
            Parameter response = new Parameter(result);
            log.info("{}.{} response：{}", service, method, JSON.toJSONString(response));
            return response;
        } catch (Exception e) {
            log.error(service + "." + method + " " + Constants.Exception_Head, e);
            throw e;
        }
    }
}
