<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.net.InetAddress"%>
<%@ page import="java.net.UnknownHostException"%>
<%!
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    String weblogicName;
    String machineCode;
    InetAddress serverAddress;
    String dateText;
    String remoteAddress;
    String remoteAddresses;
    String versionString = "20180316-v1.0.3.0";
%>
<%
    try{
        machineCode = System.getProperty("machine_code","undefined");
        weblogicName = System.getProperty("weblogic.Name","undefined");
        serverAddress = InetAddress.getLocalHost();
        dateText = sdf.format(new Date());

        String remoteAddresses = request.getHeader("x-forwarded-for");
        if(null == remoteAddresses || "".equals(remoteAddresses) || "unknown".equalsIgnoreCase(remoteAddresses))
        {
            remoteAddresses = request.getHeader("Proxy-Client-IP");
        }
        if(null == remoteAddresses || "".equals(remoteAddresses) || "unknown".equalsIgnoreCase(remoteAddresses))
        {
            remoteAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if(null == remoteAddresses || "".equals(remoteAddresses) || "unknown".equalsIgnoreCase(remoteAddresses))
        {
            remoteAddresses = request.getRemoteAddr();
        }
        if(null == remoteAddresses || "".equals(remoteAddresses) || "unknown".equalsIgnoreCase(remoteAddresses))
        {
            remoteAddresses = request.getRemoteAddr();
            if("127.0.0.1".equals(remoteAddresses) || "0:0:0:0:0:0:0:1".equals(remoteAddresses))
            {
                InetAddress address = null;
                try{
                    address = InetAddress.getLocalHost();
                    remoteAddresses = address.getHostAddress();
                }
                catch(UnknownHostException e)
                {
                    e.printStackTrace();
                }
            }
        }

        if(null != remoteAddresses && !"".equals(remoteAddresses) && !"unknown".equalsIgnoreCase(remoteAddresses))
        {
            if(remoteAddresses.length() > 15 && remoteAddresses.indexOf(",") > 0)
                remoteAddress = remoteAddresses.substring(0,remoteAddresses.indexOf(","));
            else
                remoteAddress = remoteAddresses;
        }
    }
    catch(UnknownHostException e)
    {
        e.printStackTrace();
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>SSMDemo</title>
</head>
<body>
	<h2>Hello SSM Demo!</h2>
	<p>accessDate=<%=dateText%></p>
	<p><%out.println("version=" + versionString);%></p>
	<p>weblogicName=<%= weblogicName%></p>
    <p>machineCode=<%= machineCode%></p>
    <p>=====================remote===========================</p>
    <p>remoteAddress=<%= remoteAddress%></p>
    <p>remoteAddresses=<%= remoteAddresses%></p>
    <p>=====================local=============================</p>
    <p>serverAddress=<%= serverAddress%></p>
</body>
</html>
