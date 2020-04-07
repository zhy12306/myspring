package com.myspring.mycontext;

/**
 * @ClassName HelloWorld
 * @Description
 * @DateTime 2020/1/19 9:07 下午
 * @Author yang
 */
public class HelloWorldServiceImp implements HelloWorldService {
    private String whatUWannaSay;
    private String reason;
    private OutputService outputService;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setWhatUWannaSay(String whatUWannaSay) {
        this.whatUWannaSay = whatUWannaSay;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

    public void sayHello() {
        outputService.output(whatUWannaSay);
        outputService.output(reason);
    }
}
