<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>岗位工资分析图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link rel="stylesheet" href="css/style.default.css" type="text/css" />

  </head>
  
  <body>
 <script src="js/highcharts.js"></script>
<script src="js/exporting.js"></script>

<div class="mainwrapper">
    

    <div class="header">
        <div class="logo">
            <a href="index.jsp"><img src="images/logo.png" alt="" /></a>
        </div>
        <div class="headerinner">
        </div>
    </div>
    
    <div class="leftpanel">
        
        <div class="leftmenu">        
            <ul class="nav nav-tabs nav-stacked">
            
                <li><a href="RegionSalary.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-signal"></span> <font face="微软雅黑">地区工资分布图</font></a></li>
                <li><a href="PositionSalary.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-signal"></span> <font face="微软雅黑">岗位工资分布图</font></a></li>
				<li><a href="Recruiting.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-picture"></span> <font face="微软雅黑">职位需求量分析图</font></a></li>
				<li><a href="RegionNumber.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-signal"></span> <font face="微软雅黑">地区职位需求分析图</font></a></li>
				
            </ul>
        </div><!--leftmenu-->     
    </div><!-- leftpanel -->
    
  <div class="rightpanel">
        
        <ul class="breadcrumbs">
            <li><a href="index.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li>欢迎您</li>

        </ul>
        
        <div class="pageheader">
    
            <div class="pageicon"><span class="iconfa-laptop"></span></div>
            <div class="pagetitle">
           
                <h1>欢迎您的到来</h1>
            </div>
        </div><!--pageheader-->
        
        <div class="maincontent">
            <div class="maincontentinner">
                <div class="row-fluid">
                    <div id="dashboard-left" class="span8">
                        
                     
                        <ul class="shortcuts">
                            <li class="events" style="width:160px;">
                                <a href="RegionSalary.jsp">
                                    <span class="shortcuts-icon iconsi-event"></span>
                                    <span class="shortcuts-label" style="font-size:12px; padding-left:20px;">地区工资分布图</span>
                                </a>
                            </li>
                            <li class="products" style="width:160px;">
                                <a href="PositionSalary.jsp">
                                    <span class="shortcuts-icon iconsi-event"></span>
                                    <span class="shortcuts-label"style="font-size:12px; padding-left:20px;">岗位工资分布图</span>
                                </a>
                            </li>
                            <li class="archive" style="width:160px;">
                                <a href="Recruiting.jsp" >
                                    <span class="shortcuts-icon iconsi-event"></span>
                                    <span class="shortcuts-label"style="font-size:12px; padding-left:20px;">职位需求量分析图</span>
                                </a>
                            </li>
                            <li class="help" style="width:160px;">
                                <a href="RegionNumber.jsp">
                                    <span class="shortcuts-icon iconsi-event"></span>
                                    <span class="shortcuts-label"style="font-size:12px; padding-left:22px;">地区职位需求图</span>
                                </a>
                            </li>
                          
                        </ul>
                        
                        <br />
                          
                        <br />
                        <br />
                        
                        
                    </div><!--span8-->
                    
                    <div id="dashboard-right" class="span4">
                        
                        <h5 class="subtitle">网站公告</h5>
                        
                        <div class="divider15"></div>
                        
                        <div class="alert alert-block">
                              <button data-dismiss="alert" class="close" type="button">&times;</button>
                              <h4>亲爱的用户您好：</h4>
                              <p style="margin: 8px 0">本系统已于2015年1月1日正式上线，欢迎各位用户使用。如果有任何问题，欢迎随时向我们反馈，我们期待您的宝贵意见。
<br/>电话：12345678909<br/>
          邮箱:test@163.com</p>
                        </div><!--alert-->
                        
                        <br />
                        
                      
                        
                      
                       
                        <br />
                                                
                    </div><!--span4-->
                </div><!--row-fluid-->
                
                <div class="footer">
                    <div class="footer-left">
                        <span>&copy; 2014. JAVAClass. All Rights Reserved.</span>
                    </div>
                    <div class="footer-right">
                        <span>Designed by: <a >WangCan and ZhaoJingru</a></span>
                    </div>
                </div><!--footer-->
                
            </div><!--maincontentinner-->
        </div><!--maincontent-->
        
    </div><!--rightpanel-->>
    
</div><!--mainwrapper-->
  </body>
</html>
