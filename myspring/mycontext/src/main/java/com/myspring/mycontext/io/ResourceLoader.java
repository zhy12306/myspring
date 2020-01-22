package com.myspring.mycontext.io;

import java.io.IOException;
import java.net.URL;

/**
 * 资源加载器
 *
 * @DateTime 2020/1/21 3:22 下午
 * @Author yang
 */
public class ResourceLoader {

    public Resource getResource(String resourceLocation) throws IOException {
        URL urlResource = this.getClass().getClassLoader().getResource(resourceLocation);
        return new UrlResource(urlResource);
    }

}
