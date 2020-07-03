/**
 * Copyright 2009-2015 the original author or authors.
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
package org.apache.ibatis.executor.resultset;

import org.apache.ibatis.cursor.Cursor;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 封装了对JDBC中的ResultSet对象操作，
 * 当执行SQL类型为SELECT语句时，ResultSetHandler用于将查询结果转换成Java对象<br/>
 * 只有一个实现类：DefaultResultHandler
 * @author Clinton Begin
 */
public interface ResultSetHandler {

    /**
     * 获取Statement对象中的ResultSet对象，对ResultSet对象进行处理，返回包含结果实体的List对象
     * @param stmt
     * @param <E>
     * @return
     * @throws SQLException
     */
    <E> List<E> handleResultSets(Statement stmt) throws SQLException;

    /**
     * 将ResultSet对象包装成Cursor对象，对Cursor进行遍历时，能够动态地从数据库查询数据，避免一次性将所有数据加载到内存中
     * @param stmt
     * @param <E>
     * @return
     * @throws SQLException
     */
    <E> Cursor<E> handleCursorResultSets(Statement stmt) throws SQLException;

    /**
     * 处理存储过程调用结果
     * @param cs
     * @throws SQLException
     */
    void handleOutputParameters(CallableStatement cs) throws SQLException;

}
