package com.myspring.mycontext.bean.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 内部资源定位接口
 * @DateTime 2020/1/21 3:08 下午
 * @Author yang
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
