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
<style type="text/css">
	form{
		/* width:60%; */
		/* margin-left:300px; */
	}
	select{
		border:1px solid red;
	}
</style>
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
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="cusname"  autocomplete="off" placeholder="请输入姓名" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="sex" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-block">
      <input type="text" name="tel"  autocomplete="off" placeholder="请输入电话号码" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
      <input type="text" name="qq"  autocomplete="off" placeholder="请输入QQ号码" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">意向</label>
    <div class="layui-input-block">
      <select name="asstateid" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">自身状态</label>
    <div class="layui-input-block">
      <select name="selstateid" >
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
 		  var s="Custom";
		  
		  var params=data.field;
		  if(id.length>0){
			  s="Custom/"+id;
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
	$.post("Custom/"+id,{_method:"GET"}, function(json) {
		render('myform', json);
		getarray("Custom/getSexs",{},"[name=sex]",json.sex);
		getarray("Custom/getAssignStates",{},"[name=asstateid]",json.asstateid);
		getarray("Custom/getSelfStates",{},"[name=selstateid]",json.selstateid);
	},"json");
	
} 
if(id.length>0){
	init();
}else{
	getarray("Custom/getSexs",{},"[name=sex]",0);
	getarray("Custom/getAssignStates",{},"[name=asstateid]",0);
	getarray("Custom/getSelfStates",{},"[name=selstateid]",0);
}

</script>
</body>
</html>