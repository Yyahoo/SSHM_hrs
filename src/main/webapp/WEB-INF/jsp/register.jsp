<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>高大上租房网 - 用户注册</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="images/logo.png" />
			</div>
		</div>
		<div id="regLogin" class="wrap">
			<div class="dialog">
				<dl class="clearfix">
					<dt>新用户注册</dt>
					<dd class="past">填写个人信息</dd>
				</dl>
				<div class="box">
					<form id="regForm" action="reg" method="post">
						<div class="infos">
							<table class="field">
								<tr>
									<td>&nbsp;</td>
									<td style="color: red">${hint}</td>
								</tr>
								<tr>
									<td class="field">用 户 名：</td>
									<td>
										<input id="username" type="text" class="text" name="username"> 
										<span id="isValid"></span>
									</td>
								</tr>
								<tr>
									<td class="field">密 码：</td>
									<td><input id="password" type="password" class="text" name="password"></td>
									<span id="perror" style="color:red;font-size:12px;">${perror}</span>
								</tr>
								<tr>
									<td class="field">确认密码：</td>
									<td><input id="password2" type="password" class="text" name="repassword"></td>
									<span id="perror2" style="color:red;font-size:12px;">${perror2}</span>
								</tr>
								<tr>
									<td class="field">电 话：</td>
									<td><input type="text" class="text" name="tel"></td>
								</tr>
								<tr>
									<td class="field">用户姓名：</td>
									<td><input type="text" class="text" name="realname"></td>
								</tr>
								<tr>
									<td class="field">验 证 码：</td>
									<td>
										<input type="text" class="text" name="code"> 
										<img id="code" src="code" width="80" height="30">
									</td>
								</tr>
							</table>
							<div class="buttons">
								<input type="submit" name="submit" value="立即注册" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="footer" class="wrap">
			<dl>
				<dt>高大上租房网 &copy; 2013 攀峰科技 川ICP证1000001号</dt>
				<dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
			</dl>
		</div>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
		
		
		     $(function(){
		    	 var isValid=false;
		    	 $('regForm').on('submit',function(evt){
		    	//阻止事件的默认行为
		    	evt.preventDefault();
		    	var username=$('#username').val();
		    	var password=$('#password').val();
		    	var password2=$('#password2').val();
		    	if(checkUsername(username)&&checkPassword(password,password2)){
		    		this.submit;
		    	}
		    }); 
		    	 $('#username').on('blur',function(){
		    		 checkUsername($(this).val());
		    	 });
		    	  $('#repassword').on('blur',function(){
		    		  checkPassword($('password').val(),$(this).val());
		    	  });
		    	  function checkUsername(username){
		    		  var flag=/^\w{}/{6,20}$/.test(username);
		    		  flag?$('uerror').text(''):$('#uerror').text('无效的用户名');
		    		  return flag;
		    	  }
		    	  function checkPassword(password,password2){
		    		  var flag=password.length>=6&&
		    	  }
		    	
		    	
		    	$('#username').on('blur', function() {
					var username = $(this).val();
					$.getJSON('check?username='+username,function(json){
					       isValid=json.valid;
					    $('#isValid').children().remove();
						$('#isValid').append($('<img>').attr('src','images/'+json.picture));
					});
				});
		    	$('#code').on('click', function() {
				    $(this).attr('src', 'code?' + Math.random());
				});
		    	$.ajax({
					url: 'check',
					data: { 'username': username },
					success: function(data) {
						if (data.indexOf('used') >= 0) {
							showErrorHint();
						} else {
							showCorrectHint();
						}
					}
				});
		    	
		     });
		    		 
		    		 
			 
		 
			
					
	
	
		
		</script>
	</body>
</html>

