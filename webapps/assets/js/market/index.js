$(document).ready(function(){

  $(".J_send_tab").bind("click",function(){
      if(this.id == 'li_tab_input'){
          $('.J_input_send_type').val(1);
      }else{
          $('.J_input_send_type').val(0);
      }
  });


});

