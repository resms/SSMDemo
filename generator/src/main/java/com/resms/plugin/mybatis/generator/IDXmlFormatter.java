package com.resms.plugin.mybatis.generator;

import org.mybatis.generator.api.XmlFormatter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.config.Context;

public class IDXmlFormatter implements XmlFormatter {
    protected Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String getFormattedContent(Document document) {
        String code = document.getRootElement().getName();
        return code.replaceAll("PrimaryKey","Id");
    }
}
