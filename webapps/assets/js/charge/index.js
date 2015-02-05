$(document).ready(function(){

    $(".J_charge").bind("click",function(){
//        if(this.id < 1){
//            alert("金额错误");
//            return;
//        }
//        $('.J_fee').val(this.id);
//
//        $('.J_form').submit();
        showOverlay();
    });
    $('.J_pay_success').bind("click",function(){
        window.location.href=ctx + '/account/profile.htm';
    });
    $('.J_pay_fail').bind("click",function(){
        hideOverlay();
    });

});


function showOverlay() {
    $("#overlay").height(pageHeight());
    $("#overlay").width(pageWidth());
    // fadeTo第一个参数为速度，第二个为透明度
    // 多重方式控制透明度，保证兼容性，但也带来修改麻烦的问题
    $("#overlay").fadeTo(200, 0.8);
}
/* 隐藏覆盖层 */
function hideOverlay() {
    $("#overlay").fadeOut(200);
}
/* 当前页面高度 */
function pageHeight() {
    return document.body.scrollHeight;
}
/* 当前页面宽度 */
function pageWidth() {
    return document.body.scrollWidth;
}
