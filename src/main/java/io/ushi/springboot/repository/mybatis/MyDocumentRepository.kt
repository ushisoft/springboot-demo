package io.ushi.springboot.repository.mybatis

import io.ushi.springboot.domain.jpa.Document
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * Created by zhouleibo on 2017/9/11.
 */
@Mapper
interface MyDocumentRepository {

    @Select("""
        SELECT
            *
        FROM
            document
        WHERE
            group_id = #{groupId}
    """)
    fun findByGroupId(@Param("groupId") groupId: String): List<Document>
}