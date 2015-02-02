jQuery(document).ready(function() {


    $(".b_finish").on('click', function(){
        var id = this.id;
        $.Dialog({
            overlay: true,
            shadow: true,
            flat: true,
            width: '500px',
            content: '',
            padding: 10,
            onShow: function(_dialog){
                var content = '<form id="append-row-form">' +
                    '<label>请输入淘宝交易单号:</label>'+
                    '<input type="text" name="taobaoOrder">'+
                    '<input type="hidden" name="id" value="'+id +'">' +
                    '<input type="hidden" name="_form_token" value="'+_token +'">' +
                    '<div class="form-actions">' +
                    '<button class="button primary">保存</button> '+
                    '<button class="button" type="button" onclick="$.Dialog.close()">取消</button> '+
                    '</div>'+
                    '</form>';

                $.Dialog.title("请输入淘宝交易单号");
                $.Dialog.content(content);
                $.Metro.initInputs();
                $("#append-row-form").submit(function(){
                    $(this).ajaxSubmit({
                        type:"post",
                        dataType:"json",
                        url:ctx + "buyer/task/doFinish.json",
                        success : function(data) {
                            displaySuccess({msg:data.msg});
                            reload();
                        },
                        error : function(data) {
                            displayError({msg : '请求异常'});
                        }
                    });
                    return false;
                });
            }
        });
    });


    $(".b_cancel").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "buyer/task/doCancel.json",
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

    $(".b_accept").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "buyer/task/doAccept.json",
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

    $(".b_sign").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "buyer/task/doSign.json",
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

    $(".b_break").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "buyer/task/doBreak.json",
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

    $(".b_accept").on('click', function(){
        var _id = this.id;
        $.ajax({
            type: 'POST',
            url:ctx + "buyer/task/doAccept.json",
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