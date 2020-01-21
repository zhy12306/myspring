package com.myspring.mycontext.log;

/**
 * @ClassName log
 * @DateTime 2020/1/20 4:51 下午
 * @Author yang
 */
public interface Log {
    void log(String var1, int var2, int var3, String var4);

    void log(String var1, int var2, int var3, String var4, Throwable var5);

    void init(String var1);

    void setName(String var1);
}
