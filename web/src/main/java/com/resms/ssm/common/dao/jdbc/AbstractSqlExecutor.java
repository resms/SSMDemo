package com.resms.ssm.common.dao.jdbc;

import java.sql.Connection;
import java.util.regex.Pattern;

public abstract class AbstractSqlExecutor {
    protected static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");

    protected static final String DEFAULT_DELIMITER = ";";

    protected static final Pattern DELIMITER_PATTERN = Pattern.compile("^\\s*((--)|(//))?\\s*(//)?\\s*@DELIMITER\\s+([^\\s]+)", Pattern.CASE_INSENSITIVE);

    protected final Connection connection;

    protected AbstractSqlExecutor(Connection connection) {
        this.connection = connection;
    }
}
