package com.resms.ssm.test;

import com.resms.ssm.dto.CarVO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

public class XStreamTest {
    private static XStream xStream;
    private static final String filePath = "D://car.xml";
    static {
        xStream = new XStream(new DomDriver());
    }

    @Test
    public void objectToXml() throws FileNotFoundException {
        CarVO vo = new CarVO();
        vo.setId(1L);
        vo.setName("tiggo");
        vo.setPic("red");
        vo.setCdt(new Date());
        vo.setDetail("111111111111");
        System.out.println(xStream.toXML(vo));
        FileOutputStream os = new FileOutputStream(filePath);

        xStream.toXML(vo,os);

        System.out.println("objectToXml successful! xml file at " + filePath);
    }

    @Test
    public void xmlToObject() throws FileNotFoundException {
        FileInputStream is = new FileInputStream(filePath);
        CarVO vo = (CarVO) xStream.fromXML(is);

        System.out.println(vo.getDetail());
    }

}
