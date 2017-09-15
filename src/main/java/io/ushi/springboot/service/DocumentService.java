package io.ushi.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 没有写接口，有复杂场景时重构
 *
 * Created by zhouleibo on 2017/8/30.
 */
@Service
public class DocumentService {

    private static final Logger logger = LoggerFactory.getLogger(DocumentService.class);

    public String sayHello() {
        logger.info("Hello World!");
        return "hello";
    }

    public String sayHi() {
        logger.info("Hi World!");
        return "hi";
    }
}
