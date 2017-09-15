package io.ushi.springboot.config.quartz.job;

import io.ushi.springboot.service.DocumentService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhouleibo on 2017/8/30.
 */
public class DocumentCollectJob implements Job {

    @Autowired
    private DocumentService documentService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        documentService.sayHello();
    }
}
