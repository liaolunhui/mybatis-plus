/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MybatisPlus 数据库类型
 *
 * @author hubin
 * @since 2018-06-23
 */
@Getter
@AllArgsConstructor
public enum DbType {
    /**
     * MYSQL
     */
    MYSQL("mysql", "MySql数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.MySqlDialect"),
    /**
     * MARIADB
     */
    MARIADB("mariadb", "MariaDB数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.MariaDBDialect"),
    /**
     * ORACLE
     */

    ORACLE("oracle", "Oracle数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.OracleDialect"),


    ORACLE_NEW("oracleNew", "Oracle新版数据库","com.baomidou.mybatisplus.extension.plugins.pagination.dialects.OracleNewDialect"),

    /**
     * DB2
     */
    DB2("db2", "DB2数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.DB2Dialect"),
    /**
     * H2
     */
    H2("h2", "H2数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.H2Dialect"),
    /**
     * HSQL
     */
    HSQL("hsql", "HSQL数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.HSQLDialect"),
    /**
     * SQLITE
     */
    SQLITE("sqlite", "SQLite数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.SQLiteDialect"),
    /**
     * POSTGRE
     */
    POSTGRE_SQL("postgresql", "Postgre数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.PostgreDialect"),
    /**
     * SQLSERVER2005
     */
    SQL_SERVER2005("sqlserver2005", "SQLServer2005数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.SQLServer2005Dialect"),
    /**
     * SQLSERVER
     */
    SQL_SERVER("sqlserver", "SQLServer数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.SQLServerDialect"),
    /**
     * DM
     */
    DM("dm", "达梦数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.DmDialect"),
    /**
     * xugu
     */
    XU_GU("xugu", "虚谷数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.XuGuDialect"),
    /**
     * Kingbase
     */
    KINGBASE_ES("kingbasees", "人大金仓数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.KingbaseDialect"),
    /**
     * UNKONWN DB
     */
    OTHER("other", "其他数据库", "com.baomidou.mybatisplus.extension.plugins.pagination.dialects.UnknownDialect");

    /**
     * 数据库名称
     */
    private final String db;
    /**
     * 描述
     */
    private final String desc;

    /**
     * 分页方言
     */
    private String dialect;

    private static Map<String,DbType> DB_CACHE_MAP = new ConcurrentHashMap<>();

    static {
        for (DbType dbType : DbType.values()) {
            DB_CACHE_MAP.put(dbType.getDb().toLowerCase(), dbType);
        }
    }

    /**
     * 获取数据库类型
     *
     * @param dbType 数据库类型字符串
     */
    public static DbType getDbType(String dbType) {
        return DB_CACHE_MAP.getOrDefault(dbType.toLowerCase(), OTHER);
    }
}
