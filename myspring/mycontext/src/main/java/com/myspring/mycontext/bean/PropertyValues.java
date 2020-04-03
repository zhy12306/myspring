package com.myspring.mycontext.bean;

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

    /**
     * @Desc 添加属性值
     * @Param [propertyValue]
     * @Return com.myspring.mycontext.bean.PropertyValues
     * @Author yang
     * @Date 2020/1/21
     */
    public PropertyValues addPropertyValue(PropertyValue propertyValue) {
        //TODO 这里需要对重复 PropertyName 进行判断，直接使用 List 无法做到
        this.propertyValueList.add(propertyValue);
        return this;
    }

    /**
     * @Desc 获取属性值
     * @Param []
     * @Return java.util.List<com.myspring.mycontext.bean.PropertyValue>
     * @Author yang
     * @Date 2020/1/21
     */
    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }

}
