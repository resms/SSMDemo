package org.apache.mybatis.plugin.generator;

import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.config.Context;

public class IDJavalFormatter implements JavaFormatter  {
    protected Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String getFormattedContent(CompilationUnit compilationUnit) {
        String code = compilationUnit.getFormattedContent();
        return code.replaceAll("PrimaryKey","Id");
    }
}
