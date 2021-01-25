import { Indicator } from 'mint-ui';// 加载动画
import { Toast } from 'mint-ui';

export const serverIP = 'http://127.0.0.1:80'

// ================== 需要携带token ========================
/*
 url: 请求的链接
 options: 请求传递的参数
 type: 类型，判断哪个方法调用
*/
const request = (url, options, type) => {

	return new Promise((resolve, reject) => { 

        var username = getCookie("yuqixian_username");

        $.ajax({
            url: serverIP + url,
            method: options.method,
			data: options.data,
			header: {
				'content-type': 'application/x-www-form-urlencoded;charset=utf-8',
				'yuqixian_username': username,  // 后台验证数据源
			},
            dataType: 'json',
            beforeSend: function() {// 发送请求之前
                Indicator.open({
                     text: '请稍后...',
                     spinnerType: 'fading-circle'
                 });
             },
             complete: function() {// 请求完成后回调函数 (请求成功或失败之后均调用)
                 Indicator.close();
             },
			 error: function(error) {// 发生错误
				reject(error);
                Toast({
                    message: '请求失败，请联系管理员或稍后尝试！',
                    position: 'bottom',
                    duration: 3000
                });
             },
            
            success: res => {
                resolve(res);
            },
        })

	})
}

export const get = (url, options = {}) => {
	return request(url, { method: 'GET', data: options })
}

export const post = (url, options, type) => {
	return request(url, { method: 'POST', data: options }, type)
}

export const put = (url, options) => {
	return request(url, { method: 'PUT', data: options })
}

// 不能声明DELETE（关键字）
export const remove = (url, options) => {
	return request(url, { method: 'DELETE', data: options })
}

export const getCookie = (cookieName = {}) => {// 获取cookie
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; ");
    for(var i = 0; i < arrCookie.length; i++){
        var arr = arrCookie[i].split("=");
        if(cookieName === arr[0]){
            return arr[1];
        }
    }
    return "";
}