package com.csy.demo.init;

import com.csy.demo.model.ArcType;
import com.csy.demo.service.ArcTypeService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化加载数据
 * @author Administrator
 *
 */
@Component("initSystem")
public class InitSystem implements ServletContextListener,ApplicationContextAware{

    private static ApplicationContext applicationContext;

    public static Map<String,ArcType> arcTypeMap=new HashMap<String,ArcType>();


    /**
     * 加载数据到application缓存中
     * @param application
     */
    public void loadData(ServletContext application){
        Map map = new HashMap();
        ArcTypeService arcTypeService=(ArcTypeService) applicationContext.getBean("arcTypeService");
        List<ArcType> arcTypeList=arcTypeService.list(map);
        application.setAttribute("allArcTypeList", arcTypeList); // 所有类别
        for(ArcType arcType:arcTypeList){
            arcTypeMap.put(arcType.getId(), arcType);
        }
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loadData(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

}

