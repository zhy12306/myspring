package com.myspring.mycontext.test;

/**
 * @ClassName HelloWorld
 * @Description
 * @DateTime 2020/1/19 9:07 下午
 * @Author yang
 */
public class HelloWorld  implements HelloWorldService{
    private String whatUWannaSay;
    private  String reason;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setWhatUWannaSay(String whatUWannaSay) {
        this.whatUWannaSay = whatUWannaSay;
    }

    public void sayHello() {
        System.out.println("Hello world!\r\n"+whatUWannaSay+"\r\nI'm waiting for you!!\r\n"+reason);
    }
}
