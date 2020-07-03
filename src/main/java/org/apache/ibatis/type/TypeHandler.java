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
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 是MyBatis中的类型处理器，用于处理Java类型与JDBC类型之间的映射。
 * 它的作用主要体现在能够根据Java类型调用PreparedStatement或CallableStatement对象
 * 对应的setXXX()方法为Statement对象设置值，而且能够根据Java类型调用ResultSet对象对应的getXXX()获取SQL执行结果.
 * 它是被TypeHandlerRegistry中建立的与jdbc的对应关系
 * @author Clinton Begin
 */
public interface TypeHandler<T> {

    /**
     * 用于为PreparedStatement对象参数的占位符设置值
     * @throws SQLException
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

    /**
     * 用于从ResultSet对象中获取列的值，或者获取存储过程调用结果
     * @throws SQLException
     */
    T getResult(ResultSet rs, String columnName) throws SQLException;

    T getResult(ResultSet rs, int columnIndex) throws SQLException;

    T getResult(CallableStatement cs, int columnIndex) throws SQLException;

}
