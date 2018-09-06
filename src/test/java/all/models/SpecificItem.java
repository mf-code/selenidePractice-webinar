package all.models;

import all.utils.Log;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Lists;

import java.lang.reflect.Method;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class SpecificItem extends Wrapped {
    private static final String container = "container > ul > li";

    private SpecificItem(SelenideElement source) {
        super(source);
    }

    private static SelenideElement wrap(SelenideElement source) {
        return proxyInstance(new SpecificItem(source));
    }

    public static List<SelenideElement> children(SelenideElement root) {
        return Lists.transform(root.findAll(container), SpecificItem::wrap);
    }

    private SelenideElement clickableItem() {
        Log.proxyCall(methodName, "LogId to find that place in the code");
        return source.$("span");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        methodName = method.getName();
        return getResult(
                proxy,
                methodName.equals("click") ? $(".newitem") : source, //because source element is not clickable
                method,
                args
        );
    }
}
