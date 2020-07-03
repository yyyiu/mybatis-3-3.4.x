/**
 * Copyright 2009-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.executor.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.ResultHandler;

/**
 * 封装了对JDBC Statement对象的操作，比如为Statement对象设置参数，调用Statement接口提供的方法与数据库交互，
 * 比如设置fetchSize属性，设置查询超时时间
 * 这个接口和子类设计直接的关系和Executor相似，这个接口的子类有BaseStatementHandler，这个实现类和子类直接的关系使用模板模式
 * @author Clinton Begin
 */
public interface StatementHandler {

    /**
     * 创建JDBC Statement对象，并完成Statement对象的属性设置
     *
     * @param connection
     * @param transactionTimeout
     * @return
     * @throws SQLException
     */
    Statement prepare(Connection connection, Integer transactionTimeout) throws SQLException;

    /**
     * 使用MyBatis中的ParameterHandler组件为PreparedStatement和CallableStatement参数占位符设置值
     *
     * @param statement
     * @throws SQLException
     */
    void parameterize(Statement statement) throws SQLException;

    /**
     * 将SQL命令添加到批处量执行列表中
     * @param statement
     * @throws SQLException
     */
    void batch(Statement statement) throws SQLException;

    /**
     * 调用Statement对象的execute()方法执行更新语句，例如UPDATE、INSERT、DELETE语句
     * @param statement
     * @return
     * @throws SQLException
     */
    int update(Statement statement) throws SQLException;

    /**
     * 执行查询语句，并使用ResultSetHandler处理查询结果集
     * @param statement
     * @param resultHandler
     * @param <E>
     * @return
     * @throws SQLException
     */
    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;

    /**
     * 游标的查询，返回Cursor对象，能够通过Iterator动态地从数据库中加载数据，适用于查询数据量较大的情况，避免将所有数据加载到内存中
     * @param statement
     * @param <E>
     * @return
     * @throws SQLException
     */
    <E> Cursor<E> queryCursor(Statement statement) throws SQLException;

    /**
     * 获取Mapper中配置的SQL信息，BoundSql封装了动态SQL解析后的SQL文本和参数映射信息
     * @return
     */
    BoundSql getBoundSql();

    /**
     * 获取ParameterHandler实例
     * @return
     */
    ParameterHandler getParameterHandler();

}
