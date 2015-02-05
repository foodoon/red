$(document).ready(function(){

    $(".J_charge").bind("click",function(){
        if(this.id < 1){
            alert("金额错误");
            return;
        }
        $('.J_fee').val(this.id);

        $('.J_form').submit();
    });


});
