package io.ushi.springboot.controller;

import io.ushi.springboot.domain.jpa.Document;
import io.ushi.springboot.repository.jpa.JpaDocumentRepository;
import io.ushi.springboot.repository.mybatis.MyDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Doc主页控制类
 * <p>
 * Created by zhouleibo on 2017/8/30.
 */
@RestController
@RequestMapping("/doc")
public class DocumentController {

    @Autowired
    private JpaDocumentRepository jpaDocumentRepository;

    @Autowired
    private MyDocumentRepository myDocumentRepository;

    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public Document document(@PathVariable("id") Long documentId) {

        // insert data by h2-console
        return jpaDocumentRepository.findDocument(documentId);
    }

    @RequestMapping(value = "/group/{gid}/artifacts", method = RequestMethod.GET)
    public List<Document> artifacts(@PathVariable("gid") String groupId) {

        // insert data by h2-console
//        return jpaDocumentRepository.findByGroupId(groupId);
        return myDocumentRepository.findByGroupId(groupId);
    }

    @RequestMapping(value = "/group/{gid}/artifact/{aid}/versions", method = RequestMethod.GET)
    public List<String> versions(@PathVariable("gid") String groupId, @PathVariable("aid") String artifactId) {

        List<String> g1 = new ArrayList<String>();
        g1.add("E");
        g1.add("F");

        List<String> g2 = new ArrayList<String>();
        g2.add("G");
        g2.add("H");

        return artifactId.equals("common") ? g1 : g2;
    }
}
