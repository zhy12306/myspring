package com.myspring.mycontext.bean;

/**
 * 用于bean的属性注入
 * @DateTime 2020/1/21 10:11 上午
 * @Author yang
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
