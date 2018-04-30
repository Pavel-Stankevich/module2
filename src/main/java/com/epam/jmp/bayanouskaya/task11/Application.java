package com.epam.jmp.bayanouskaya.task11;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class Application implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("*.html");
    }
}
