$(document).ready(function(){

  var isAnimating = false;

  $(".fruit").mouseenter(function(){
    $(this).find("span").css("display", "block");
  });

  $(".fruit").mouseleave(function(){
    $(this).find("span").css("display", "none");
  });

  $(".fruit").click(function(){

    if(isAnimating == false) {

      isAnimating = true;

      if ($(this).hasClass("Up")){
          $(".Up").animate( {top: "0"} , 400, function(){isAnimating = false;});
          $(".Up").removeClass('Up');

      }

      else {
        $(".Up").animate( {top: "0"} , 400, function(){});
        $(".Up").removeClass('Up');
        $(this).animate( {top: "-10vw"} , 400, function(){isAnimating = false;});
        $(this).addClass('Up');
      }

    }

  });





});
