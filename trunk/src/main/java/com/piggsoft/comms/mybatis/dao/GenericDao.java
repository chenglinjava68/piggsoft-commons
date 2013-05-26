package com.piggsoft.comms.mybatis.dao;
/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-5-25
 * @version 1.0
 */
import java.io.Serializable;
import java.util.List;

/**
 * GenericDao DAO层泛型接口，定义基本的DAO功能
 * @author char chen
 * @since 0.1
 * @param <T>    实体类
 * @param <PK>    主键类，必须实现Serializable接口
 * 
 */
public abstract interface GenericDao<T, PK extends Serializable> {
    /**
     * 插入一个实体（在数据库INSERT一条记录）
     * @param entity 实体对象
     */
    public abstract void insert(T entity);
    
    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    public abstract int update(T entity);
    
    
    /**
     * 按主键删除记录
     * @param primaryKey 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    public abstract int delete(PK primaryKey);

    /**
     * 删除符合条件的记录
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>
     * @param param 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
     * @return
     */
    public abstract int delete(Object param);
    
    /**
     * 清空表，比delete具有更高的效率，而且是从数据库中物理删除（delete是逻辑删除，被删除的记录依然占有空间）
     * <p><strong>此方法一定要慎用！</strong></p>
     * @return
     */
    public abstract int truncate();
    
    /**
     * 查询整表总记录数
     * @return 整表总记录数
     */
    public abstract int count();
    
    /**
     * 查询符合条件的记录数
     * @param param 查询条件参数，包括WHERE条件（其他参数内容不起作用）。此参数设置为null，则相当于count()
     * @return
     */
    public abstract int count(Object param);

    /**
     * 按主键取记录
     * @param primaryKey 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public abstract T get(PK primaryKey);

    /**
     * 按主键取记录
     * @param primaryKey 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则 throw DataAccessException
     */
    public abstract T load(PK primaryKey);

    /**
     * 取全部记录
     * @return 全部记录实体对象的List
     */
    public abstract List<T> select();
    
    /**
     * 按条件查询记录
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件
     * @return 符合条件记录的实体对象的List
     */
    public abstract List<T> select(Object param);
    
    
    /**
     * 按条件查询记录，并把有外键关联的字段的关联对象也处理出来
     * <p>此方法是为了避免1+N而设置的</p>
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件<strong>（不包括外键关联表条件）</strong>
     * @return 符合条件记录的实体对象的List
     */
    public abstract List<T> selectFk(Object param);
    
    
    /**
     * 批量插入
     * @param list
     */
    public abstract void batchInsert(final List<T> list);
    
    /**
     * 批量修改
     * @param list
     */
    public abstract void batchUpdate(final List<T> list);
    
    /**
     * 批量删除
     * @param list
     */
    public abstract void batchDelete(final List<PK> list);
}
