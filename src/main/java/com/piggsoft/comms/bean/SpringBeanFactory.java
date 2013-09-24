package com.piggsoft.comms.bean;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringBeanFactory implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
	}

	public static void loadApplicationContext(String[] xmlConfig)
			throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(xmlConfig);
	}

	public static void loadApplicationContext(ServletContext servletContext)
			throws Exception {
		applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
	}

	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"'applicationContext' property is null,ApplicationContextHolder not yet init.");
		}
		return applicationContext;
	}
	
	public static void registerBean(String beanName, Class<?> beanClass, String scope,String refPropertyName, String refBeanName) {
		Map<String, String> refer = new HashMap<String, String>();
		refer.put(refPropertyName, refBeanName);
	}
	
	public static void registerBean(String beanName, Class<?> beanClass, String scope,Map<String, String> refer) {
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)getApplicationContext();
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)configurableApplicationContext.getBeanFactory();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass).setScope(scope);
		addPropertyReference(builder, refer);
		beanFactory.registerBeanDefinition(beanName, builder.getRawBeanDefinition());
	}
	
	private static void addPropertyReference(BeanDefinitionBuilder builder, Map<String, String> refer) {
		for(Entry<String, String> entry : refer.entrySet()) {
			builder.addPropertyReference(entry.getKey(), entry.getValue());
		}
	}
	
	public static Object getBean(String name) throws BeansException {
		return getApplicationContext().getBean(name);
	}

	public static <T> T getBean(String name, Class<T> requiredType)
			throws BeansException {
		return getApplicationContext().getBean(name, requiredType);
	}

	public static <T> T getBean(Class<T> requiredType) throws BeansException {
		return getApplicationContext().getBean(requiredType);
	}

	public static Object getBean(String name, Object... args)
			throws BeansException {
		return getApplicationContext().getBean(name, args);
	}

	public static boolean containsBean(String name) {
		return getApplicationContext().containsBean(name);
	}

	public static boolean isSingleton(String name)
			throws NoSuchBeanDefinitionException {
		return getApplicationContext().isSingleton(name);
	}

	public static boolean isPrototype(String name)
			throws NoSuchBeanDefinitionException {
		return getApplicationContext().isPrototype(name);
	}

	public static boolean isTypeMatch(String name, Class<?> targetType)
			throws NoSuchBeanDefinitionException {
		return getApplicationContext().isTypeMatch(name, targetType);
	}

	public static Class<?> getType(String name)
			throws NoSuchBeanDefinitionException {
		return getApplicationContext().getType(name);
	}

	public static String[] getAliases(String name) {
		return getApplicationContext().getAliases(name);
	}

	public static boolean containsBeanDefinition(String beanName) {
		return getApplicationContext().containsBeanDefinition(beanName);
	}

	public static int getBeanDefinitionCount() {
		return getApplicationContext().getBeanDefinitionCount();
	}

	public static String[] getBeanDefinitionNames() {
		return getApplicationContext().getBeanDefinitionNames();
	}

	public static String[] getBeanNamesForType(Class<?> type) {
		return getApplicationContext().getBeanNamesForType(type);
	}

	public static String[] getBeanNamesForType(Class<?> type,
			boolean includeNonSingletons, boolean allowEagerInit) {
		return getApplicationContext().getBeanNamesForType(type,
				includeNonSingletons, allowEagerInit);
	}

	public static <T> Map<String, T> getBeansOfType(Class<T> type)
			throws BeansException {
		return getApplicationContext().getBeansOfType(type);
	}

	public static <T> Map<String, T> getBeansOfType(Class<T> type,
			boolean includeNonSingletons, boolean allowEagerInit)
			throws BeansException {

		return getApplicationContext().getBeansOfType(type, includeNonSingletons,
				allowEagerInit);
	}

	public static Map<String, Object> getBeansWithAnnotation(
			Class<? extends Annotation> annotationType) throws BeansException {

		return getApplicationContext().getBeansWithAnnotation(annotationType);
	}

	public static <A extends Annotation> A findAnnotationOnBean(
			String beanName, Class<A> annotationType) {
		return getApplicationContext()
				.findAnnotationOnBean(beanName, annotationType);
	}

	public static Resource[] getResources(String locationPattern)
			throws IOException {
		return getApplicationContext().getResources(locationPattern);
	}

}
