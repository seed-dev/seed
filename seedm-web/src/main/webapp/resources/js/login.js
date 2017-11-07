$(document).ready(function () {
    //登录
    $('#loginBut').click(function () {
        var data = {
            mobile: $('#mobile').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: "POST",
            url: "/seedm/login/submit",
            data: data,
            dataType: 'json',
            success: function(result){
                console.log(result);
                if(result && result.flag == 0) {
                    console.log(result.msg);
                } else if (result && result.flag == 1) {
                    window.location.href = '/seedm/';
                }
            }
        });

        // if(mobile.length != 0 && password.length != 0) {
        //     console.log('用户：' + mobile + ",使用密码：" + password + "登录了！");
        // } else {
        //     console.log('No Account And Password!');
        //     return false;
        // }

        return false;
    });

    //忘记密码
    $('#forgetPwd').click(function () {

    });
});
