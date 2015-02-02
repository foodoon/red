jQuery(document).ready(function() {


    $(".s_cancel").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "seller/act/doCancel.json",
            dataType:"json",
            data: {id:_id,_form_token:_token},
            success : function(data) {
                displaySuccess({msg:data.msg});
                reload();
            },
            error : function(data) {
                displayError({msg : '请求异常'});
            }

        });

    });

    $(".s_break").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "seller/act/doAccept.json",
            dataType:"json",
            data: {id:_id,_form_token:_token},
            success : function(data) {
                displaySuccess({msg:data.msg});
                reload();
            },
            error : function(data) {
                displayError({msg : '请求异常'});
            }
        });
    });



    $(".s_confirm").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "seller/act/doConfirm.json",
            dataType:"json",
            data: {id:_id,_form_token:_token},
            success : function(data) {
                displaySuccess({msg:data.msg});
                reload();
            },
            error : function(data) {
                displayError({msg : '请求异常'});
            }
        });
    });

});