$(function(){
    $("#query .submit").on("click",function(){
        operating.query();
    });
    $("#add .submit").on("click",function(){
        operating.add();
    });
    $("#delete .submit").on("click",function(){
        operating.delete();
    })
});
var operating = {
    query:function(){
        console.log("点击:");
        $.ajax({
            url:"/server/queruySql.json",
            method:"get",
            success:function(data){
                console.log(data)
            }
        })
    },
    add:function(){
        var date = $("#add .add-info-wrap input").eq(3).val();
        date = new Date(date);
        var data = {
            id:$("#add .add-info-wrap input").eq(0).val(),
            name:$("#add .add-info-wrap input").eq(1).val(),
            description:$("#add .add-info-wrap input").eq(2).val(),
            date: $("#add .add-info-wrap input").eq(3).val()
        }
        $.ajax({
            url:"/server/addSql.json",
            method:"post",
            data:data,
            success:function(data){
                console.log(data)
            }
        })
    },
    delete:function () {
        var data = {
            id:$("#delete .add-info-wrap input").eq(0).val()
        };
        $.ajax({
            url:"/server/deleteSql.json",
            method:"post",
            data:data,
            success:function(data){
                console.log(data)
            }
        })
    }
}
