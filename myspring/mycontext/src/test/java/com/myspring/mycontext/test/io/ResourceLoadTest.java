package com.myspring.mycontext.test.io;

import com.myspring.mycontext.io.Resource;
import com.myspring.mycontext.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @DateTime 2020/1/22 3:13 下午
 * @Author yang
 */
public class ResourceLoadTest {
    @Test
    public void testIO() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("myspringcontextIOC.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);

    }
}
