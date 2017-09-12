package io.ushi.springboot.repository.mybatis

import io.ushi.springboot.domain.jpa.Document
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

/**
 * Created by zhouleibo on 2017/9/11.
 */
@Repository
@Mapper
interface MyDocumentRepository {

    /**
     * 动态SQL需要用<script>标签包裹
     */
    @Select("""<script>
        SELECT
            *
        FROM
            document
        <if test="groupId != 'all'">
        WHERE
            group_id = #{groupId}
        </if>
    </script>""")
    fun findByGroupId(@Param("groupId") groupId: String): List<Document>

}