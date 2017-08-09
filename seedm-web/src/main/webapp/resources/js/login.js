window.onload = function () {
    var LoginForm = new Vue({
        el: '#loginForm',
        data: {
            account: '',
            password: ''
        },
        methods: {
            login: function () {
                if(this.account.length != 0 && this.password.length != 0) {
                    console.log('用户：' + this.account + ",使用密码：" + this.password + "登录了！");
                    window.location.href = '/seedm/main/index';
                } else {
                    console.log('No Account And Password!');
                }
            }
        }
    });
};
