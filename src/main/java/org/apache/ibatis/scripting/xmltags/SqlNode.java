/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.scripting.xmltags;

/**
 * 解析 SQL 片段
 * StaticTextSqlNode 用于存储静态文本
 * TextSqlNode 用于存储带有 ${} 占位符的文本
 * IfSqlNode 则用于存储 <if> 节点的内容
 * MixedSqlNode 内部维护了一个 SqlNode 集合，用于存储各种各样的 SqlNode
 * @author Clinton Begin
 */
public interface SqlNode {
  boolean apply(DynamicContext context);
}
