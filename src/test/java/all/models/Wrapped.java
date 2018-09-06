package all.models;

import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.Thread.currentThread;

public abstract class Wrapped implements InvocationHandler {
    protected final SelenideElement source;
    private final Class<?>[] interfaces =
            new Class<?>[]{SelenideElement.class};
    protected String methodName;        //used by Log

    protected Wrapped(SelenideElement elementToWrap) {
        this.source = elementToWrap;
    }

    @SuppressWarnings("unchecked")
    protected static SelenideElement proxyInstance(Wrapped proxy) {
        return (SelenideElement) Proxy.newProxyInstance(
                currentThread().getContextClassLoader(),
                proxy.interfaces,
                proxy
        );
    }

    protected Object getResult(Object proxy, SelenideElement target, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result != null && result.equals(target) ? proxy : result;
    }
}
