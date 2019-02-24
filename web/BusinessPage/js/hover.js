$(document).ready(function() {

    $('.artworkImage').mouseenter(function() {
      $(this).find(".opacityLayer").css("display", "block");
    });

    $('.artworkImage').mouseleave(function() {
      $(this).find(".opacityLayer").css("display", "none");
    });

    $('.artworkImage').mouseenter(function() {
      $(this).find("#rightButton").css("display", "block");
      $(this).find("#leftButton").css("display", "block");
    });

    $('.artworkImage').mouseleave(function() {
    $(this).find("#rightButton").css("display", "none");
    $(this).find("#leftButton").css("display", "none");
    });

});
