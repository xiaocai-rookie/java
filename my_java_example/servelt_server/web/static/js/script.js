/**
 * Created by Administrator on 2017/6/21 0021.
 */
$(function(){
    $("#btn").on("click",function(){
        var number1 = $("#username").val();
        var number3 = $("#password").val();
        var number2 = $("#password2").val();

        $.ajax({
            url:"/server/login",
            method:"get",
            contentType:"application/x-www-form-urlencode; charset=UTF-8",
            data:{number1:number1,number2:number2,number3:number3},
            success:function(data){
                console.log(data)
            }
        });

    });
    $("#btn1").on("click",function(){
        var number4 = $("#result1").val();
        $.ajax({
            url:"login",
            method:"post",
            contentType:"application/x-www-form-urlencode; charset=UTF-8",
            data:{number1:number4},
            success:function(data){
                console.log(data)
            }
        })
    })
})