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
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function () {
        var name = new Array();
        var value = new Array();
        $.ajax({
                type:"POST",
                url:"action/PositionSalaryAction.action",
                dataType:'json',
                async:false,
                success:function(data){
                // 返回如下json 格式数据
        //        {"data":[
        //                { "mouth": "1", "val":"3"},
        //                { "mouth": "2", "val":"6"},
        //                { "mouth": "3", "val":"8"}
                //]}
                        //对数据进行加工处理，也可以按你自己的需求进行处理
                        if(data!=null && data.length != 0){
                                for(var w=0;w<data.length;w++){
                                        //此处楼主需要显示的X轴为"X月份"这么个字符串，后台取得的数据而仅仅为数字，对此进行加工
                                        name.push(data[w].name);
                                        //也可以在对数据的处理放在highchart 中进行处理。
                                        value.push(data[w].value);
                                }        
                        }

                        //若后台返回的数据仅仅是json 样子的的字符串
                        //那需要将其格式化
                        //然后即可对数据进行类似操作。
                        var dataTmp = eval(data);
                        /*

                        ...

                        */
                       
                      
                }

        },'json');
        
        $('.maincontentinner').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: '岗位工资分布柱状图'
            },
            xAxis: {
                type: 'category',
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '工资待遇(k)'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                pointFormat: '平均工资为: <b>{point.y:.1f} 元</b>',
            },
             credits: { enabled:false },
            series: [{
                name: '岗位工资分析图',
                data: (function() { 
                      // generate an array of random data 
                      var data = [], 
                          i; 
      
                      for (i = 0; i <name.length; i++) { 
                          data.push([
                              name[i],
                              value[i]
                          ]); 
                      } 
                      return data; 
                  })(),

                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                }
                
                     
            }]
        });
    });

</script>
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
                <li class="active"><a href="PositionSalary.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-signal"></span> <font face="微软雅黑">岗位工资分布图</font></a></li>
				<li><a href="Recruiting.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-picture"></span> <font face="微软雅黑">职位需求量分析图</font></a></li>
				<li><a href="RegionNumber.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-signal"></span> <font face="微软雅黑">地区职位需求分析图</font></a></li>
				
            </ul>
        </div><!--leftmenu-->     
    </div><!-- leftpanel -->
    
    <div class="rightpanel">
        
        <ul class="breadcrumbs">
            <li><a href="index.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li>岗位工资分布柱状图</li>
        
        </ul>
        
       
        
        <div class="maincontent">
            <div class="maincontentinner">
                <div class="row-fluid">
						
		           </div><!--span8-->
                    
                
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
        
    </div><!--rightpanel-->
    
</div><!--mainwrapper-->
  </body>
</html>
