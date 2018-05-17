package com.resms.ssm.test.view.resolver;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FreeMarkerUtil {
    private static final Logger logger = LoggerFactory.getLogger(FreeMarkerUtil.class);
    private static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
    private static final String PATH_FTL = "/ftl";
    /**
     * 根据模板文件名获得模板对象
     * @param name 模板文件名，需要带后缀
     * @return
     */
    public static Template getTemplate(String name) {
        try {
            //设定在类路径内的ftl文件夹加载ftl模板文件
            cfg.setClassForTemplateLoading(FreeMarkerUtil.class,PATH_FTL);

            //在模板文件目录中找到名称为name的文件
            Template temp = cfg.getTemplate(name);
            return temp;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public static void print(String name,Map<String,Object> root) {
        try {
            //通过Template可以将模板文件输出到相应的流
            Template temp = getTemplate(name);
            temp.process(root, new PrintWriter(System.out));
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static void fprint(String name,Map<String,Object> root,String outFile) {
        FileWriter out = null;
        try {
            //通过一个文件输出流，就可以写到相应的文件中
            String path = System.getProperty("user.dir");

            out = new FileWriter(new File(path + File.separator + outFile));
            Template temp = getTemplate(name);
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out!=null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
