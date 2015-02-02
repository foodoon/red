jQuery(document).ready(function() {



    $(".a_pass").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "admin/user/doPass.json",
            dataType:"json",
            data: {id:_id,_form_token:_token },
            success : function(data) {
                displaySuccess({msg:data.msg});
                reload();
            },
            error : function(data) {
                displayError({msg : '请求异常'});
            }
        });
    });

    $(".a_forbit").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "admin/user/doForbit.json",
            dataType:"json",
            data: {id:_id,_form_token:_token },
            success : function(data) {
                displaySuccess({msg:data.msg});
                reload();
            },
            error : function(data) {
                displayError({msg : '请求异常'});
            }
        });
    });

    $(".a_reuse").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "admin/user/doReuse.json",
            dataType:"json",
            data: {id:_id,_form_token:_token },
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