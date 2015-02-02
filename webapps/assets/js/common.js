function displayError(params) {
    jQuery('#error').html(params.msg);
    jQuery('#errorBox').show();
    reload();
    return false;
}
function displaySuccess(params) {
    if (jQuery("#tip_message").text().length > 0) {
        var msg = "<span>" + params.msg + "</span>";
        jQuery("#tip_message").empty().append(msg);
    } else {
        var msg = "<div id=\"tip_message\"><span>" + params.msg + "</span></div>";
        jQuery("body").append(msg);
    }
    jQuery("#tip_message").fadeIn("slow");
    jQuery("#tip_message").fadeOut("slow")
};

function reload() {
    window.location.reload();
}