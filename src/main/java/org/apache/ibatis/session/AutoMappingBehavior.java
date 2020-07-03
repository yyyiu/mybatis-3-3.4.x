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
package org.apache.ibatis.session;

/**
 * 指定MyBatis是否以及如何自动将列映射到字段/属性
 * 
 * @author Eduardo Macarron
 */
public enum AutoMappingBehavior {

  /**
   * NONE表示取消自动映射
   */
  NONE,

  /**
   * PARTIAL只会自动映射没有定义嵌套的结果集
   */
  PARTIAL,

  /**
   * FULL自动映射复杂的结果集
   */
  FULL
}
