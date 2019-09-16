<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<base href="../">
<meta charset="UTF-8">
<link href="layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="layui/layui.all.js"></script>
<script src="js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>

<form class="layui-form" lay-filter="myform">

<c:if test="${param.id!=null}">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="username"  autocomplete="off" placeholder="请输入用户名" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">手机号</label>
    <div class="layui-input-block">
        <input type="text" name="tel"  autocomplete="off" placeholder="请输入手机号" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="ustatuid" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
var id="${param.id}";

layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
 		  var s="User";
		  
		  var params=data.field;
		  if(id.length>0){
			  s="User/"+id;
			  params["_method"]="PUT";//修改
		  }
		  	 
		  //else
		  //  params["_method"]="POST";//插入
		  //var json1 = JSON.stringify(params)
		 //console.log(json1);
		 $.post(s, params, function(json) {
			 //console.log(data.field);
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});




function init(){
	 $.post("User/"+id,{_method:"GET"}, function(json) {
		render('myform', json);
		getUstatulist("User/getStatus",{},"[name=ustatuid]",json.ustatuid);
		//getlist("User/getTypes.action",{},"[name=typeid]",json.typeid);
	},"json");
	
} 
if(id.length>0){
	init();
}else{
	getUstatulist("User/getStatus",{},"[name=ustatuid]",0);
	//getlist("User/getTypes.action",{},"[name=typeid]",0); 
}

</script>
</body>
</html>