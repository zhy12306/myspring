package com.myspring.mycontext;

import java.util.ArrayList;
import java.util.List;

/**
 * 包装一个对象所有的PropertyValue。<br/>
 * 为什么封装而不是直接用List?因为可以封装一些操作。
 *
 * @DateTime 2020/1/21 10:13 上午
 * @Author yang
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public PropertyValues addPropertyValue(PropertyValue propertyValue) {
        //TODO 这里需要对重复 PropertyName 进行判断，直接使用 List 无法做到
        this.propertyValueList.add(propertyValue);
        return this;
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }

}
