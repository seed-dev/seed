$(document).ready(function () {
    //登录
    $('#loginBut').click(function () {
        var mobile = $('#mobile').val();
        var password = $('#password').val();

        if(mobile.length != 0 && password.length != 0) {
            console.log('用户：' + mobile + ",使用密码：" + password + "登录了！");
        } else {
            console.log('No Account And Password!');
            return false;
        }
    });

    //忘记密码
    $('#forgetPwd').click(function () {

    });
});
