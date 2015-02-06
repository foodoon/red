$(document).ready(function(){
    var arr=['wait_pay','send_item','recv_item','sign','positive_comment','refund'];
    for(var i=0;i<arr.length;i++){
        var tid = arr[i];
        $(".J_" + tid).bind("click",{t:tid},function(p){
            var t = p.data.t;
            var text = $('.J_'+ t +'_text').text();
            var action = 0;
            if('打开' === text){
                action = 0;
            }else{
                action = 1;
            }
            $.ajax({
                type: "POST",
                url: ctx + "msgNotice/set.json",
                data: "action=" + action + "&t="+t,
                dataType:'json',
                success: function(msg){
                    if(msg.success){
                        if('打开' == text){
                            $(".J_"+t+"_text")[0].innerHTML='关闭';
                            $(".J_" + t).removeClass('am-icon-toggle-on')
                            $(".J_" +t).addClass('am-icon-toggle-off')
                        }else{
                            $(".J_" + t +"_text")[0].innerHTML='打开';
                            $(".J_" + t).removeClass('am-icon-toggle-off')
                            $(".J_" + t).addClass('am-icon-toggle-on')
                        }
                    }else{
                        alert(msg.msg)
                    }
                },
                error: function(msg){
                    alert(msg.msg);
                }
            });
        });
    }


    $.ajax({
        type: "POST",
        url: ctx + "/stat.json",
        dataType:'json',
        success: function(msg){
            if(msg.success){

                $(".J_today_send")[0].innerHTML=msg.msg.todaySendCount;
                $(".J_today_order")[0].innerHTML=msg.msg.todayOrder;
                $(".J_last_send")[0].innerHTML=msg.msg.lastSendCount;
                $(".J_last_order")[0].innerHTML=msg.msg.lastOrder;
            }else{
                alert(msg.msg)
            }
        },
        error: function(msg){
            alert(msg.msg);
        }
    });






});
