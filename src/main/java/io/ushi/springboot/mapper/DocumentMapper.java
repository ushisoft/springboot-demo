package io.ushi.springboot.mapper;

import io.ushi.springboot.model.Document;

public interface DocumentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Document
     *
     * @mbg.generated Thu Sep 14 21:18:18 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Document
     *
     * @mbg.generated Thu Sep 14 21:18:18 CST 2017
     */
    int insert(Document record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Document
     *
     * @mbg.generated Thu Sep 14 21:18:18 CST 2017
     */
    int insertSelective(Document record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Document
     *
     * @mbg.generated Thu Sep 14 21:18:18 CST 2017
     */
    Document selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Document
     *
     * @mbg.generated Thu Sep 14 21:18:18 CST 2017
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Document
     *
     * @mbg.generated Thu Sep 14 21:18:18 CST 2017
     */
    int updateByPrimaryKey(Document record);
}