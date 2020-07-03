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
package org.apache.ibatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 是在 PreparedStatementHandler 和 CallableStatementHandler
 * 操作对应的Statement执行数据库交互之前为参数占位符设置值<br/>
 * 只有一个实现类：DefaultParameterHandler
 * @author Clinton Begin
 */
public interface ParameterHandler {

    /**
     * 用于获取执行Mapper时传入的参数对象
     * @return
     */
    Object getParameterObject();

    /**
     * 为JDBC PreparedStatement或者CallableStatement对象设置参数值
     * @param ps
     * @throws SQLException
     */
    void setParameters(PreparedStatement ps) throws SQLException;

}
