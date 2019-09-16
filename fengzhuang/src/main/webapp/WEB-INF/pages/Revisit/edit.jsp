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
<script type="text/javascript" src="layDate/laydate/laydate.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
form{
/* width:60%;

margin-left:300px;  */
/* border:1px solid red; */
}
</style>

<form class="layui-form" lay-filter="myform">

<c:if test="${param.id!=null}">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">操作员名</label>
    <div class="layui-input-block">
      <input type="text" name="username"  autocomplete="off" placeholder="请输入操作员名" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户名</label>
    <div class="layui-input-block">
      <input type="text" name="cusname"  autocomplete="off" placeholder="请输入客户名" class="layui-input">
    </div>
  </div>
  
   <!-- <div class="layui-form-item">
    <label class="layui-form-label">时间</label>
    <div class="layui-input-block">
      <input type="input" name="time"  autocomplete="off"  class="layui-input">
    </div>
  </div> -->
  
  
  <div class="layui-inline">
		<label class="layui-form-label">时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="test5" name="time"
				placeholder="yyyy-MM-dd HH:mm:ss">
		</div>
	</div>
  
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">问题</label>
    <div class="layui-input-block">
      <input type="text" name="ques"  autocomplete="off" placeholder="请输入问题" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">解决方案</label>
    <div class="layui-input-block">
      <input type="text" name="method"  autocomplete="off" placeholder="请输入解决方案" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">下次预约id</label>
    <div class="layui-input-block">
      <input type="text" name="nextdateid"  autocomplete="off" placeholder="下次预约id" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="备注" class="layui-input">
    </div>
  </div>
  
  
   <!-- <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select name="typeid" >
      </select>
    </div>
  </div> -->
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">


layui.use([ 'form', 'laydate' ], function() { //如果只加载一个模块，可以不填数组。

	var laydate = layui.laydate;

	/* laydate.render({
		elem : '#test1',
		trigger : 'click' //采用click弹出
	}); */

	laydate.render({
		elem : '#test5',
		type : 'datetime',
		trigger : 'click' //采用click弹出
	});

	var form = layui.form;
	form.on('submit(demo1)', function(data) {
		$.post($("form").attr("action"), data.field, function(json) {
			closeFrame();
			parent.fresh('demo');
		}, "json");

		return false;
	});
});





var id="${param.id}";

layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
 		  var s="Revisit";
		  
		  var params=data.field;
		  if(id.length>0){
			  s="Revisit/"+id;
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
	$.post("Revisit/"+id,{_method:"GET"}, function(json) {
		render('myform', json);
		//getarray("Book/getSexs.action",{},"[name=sex]",json.sex);
		//getlist("Book/getTypes.action",{},"[name=typeid]",json.typeid);
	},"json");
	
} 
if(id.length>0){
	init();
}else{
	//getarray("Book/getSexs.action",{},"[name=sex]",0);
	//getlist("Book/getTypes.action",{},"[name=typeid]",0);
}

</script>
</body>
</html>