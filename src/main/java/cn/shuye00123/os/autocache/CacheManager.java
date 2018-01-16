package cn.shuye00123.os.autocache;

import cn.shuye00123.os.autocache.annotation.Cache;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuye on 2018/1/16.
 */
@Component
public class CacheManager implements ApplicationContextAware {

    private List<Method> cacheMethods = new ArrayList<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = applicationContext.getBean(beanName);
            for (Method method : bean.getClass().getMethods()) {
                if (method.isAnnotationPresent(Cache.class)) {
                    cacheMethods.add(method);
                }
            }
        }
    }

    public List<Method> getCacheMethods() {
        return cacheMethods;
    }

    
}
