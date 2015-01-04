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
    
    <title>地区工资分析图</title>
    
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
        var city=new Array();//各个城市
        var number = new Array();//各城市工资的数组
        $.ajax({
                type:"POST",
                url:"action/RegionNumberAction.action",
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
                                        //存入各城市工资
                                        number.push(data[w].peopleNumber);
                                        city.push(data[w].city);
                                        //alert(money);
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
                text: '各地区招聘人数分析图'
            },
            xAxis: {
                categories: [
                    'Android工程师',
                    'C++工程师',
                    'Ios工程师',
                    'JAVA工程师',
                    'Web工程师'
                ]
            },
            yAxis: {
                min: 0,
                title: {
                    text: '招聘人数(人)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px;">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0;font-size:5px;min-width:30px;">{series.name}: </td>' +
                    '<td style="padding:0;font-size:5px;min-width:70px;"><b>{point.y:.1f} 人</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
             credits: { enabled:false },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [
            {
                name: city[0],
                data: number[0]
    
            }, {
                name: city[1],
                data: number[1]
    
            }, {
                name: city[2],
                data: number[2]
    
            }, {
                name: city[3],
                data: number[3]
    
            },{
                name:city[4],
                data:number[4]
            }]
        });
    });
    
</script>

  </head>
  
  <body>
  <script src="js/highcharts.js"></script>
  <script src="js/modules/exporting.js"></script>
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
				<li class="active"><a href="RegionNumber.jsp" style="letter-spacing:3px;font-size:16px;color:white;"><span class="iconfa-signal"></span> <font face="微软雅黑">地区职位需求分析图</font></a></li>

            </ul>
        </div><!--leftmenu-->     
    </div><!-- leftpanel -->
    
    <div class="rightpanel">
        
        <ul class="breadcrumbs">
            <li><a href="index.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li>各地区招聘人数分析图</li>
        
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
