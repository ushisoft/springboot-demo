package io.ushi.springboot.repository.jpa;

import io.ushi.springboot.domain.jpa.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by zhouleibo on 2017/9/2.
 */
public interface JpaDocumentRepository extends CrudRepository<Document, Long> {

    List<Document> findByGroupId(String groupId);

    /**
     * Query注解示例
     *
     * @param id
     * @return
     */
    @Query("select d from Document d where d.id=:id")
    Document findDocument(@Param("id") Long id);

}
