package com.myspring.mycontext.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ω
 *
 * @ClassName MyContextLog
 * @DateTime 2020/1/20 4:50 下午
 * @Author yang
 */
public class MyContextLog implements Log {
    private String name;

    @Override
    public void log(String component, int type, int level, String message) {
        log(component, type, level, message, null);
    }

    @Override
    public void log(String component, int type, int level, String message, Throwable exception) {
        Logger logger = LoggerFactory.getLogger(component);
        switch (type) {
            case 0:
                if (!(logger.isDebugEnabled())) {
                    return;
                }
                if (exception == null) {
                    logger.debug(message);
                    return;
                }
                logger.debug(message, exception);
                break;
            case 1:
                if (!(logger.isTraceEnabled())) {
                    return;
                }
                if (exception == null) {
                    logger.trace(message);
                    return;
                }
            case 2:
                if (!(logger.isInfoEnabled())) {
                    return;
                }
                if (exception == null) {
                    logger.info(message);
                    return;
                }
                logger.info(message, exception);
                break;
            case 3:
                if (exception == null) {
                    logger.warn(message);
                    return;
                }
                logger.warn(message, exception);
                break;
            case 4:
                if (exception == null) {
                    logger.error(message);
                    return;
                }
                logger.error(message, exception);
        }

    }

    @Override
    public void init(String logSettingFile) {

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
