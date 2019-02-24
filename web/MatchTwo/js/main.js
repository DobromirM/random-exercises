var back = "img/back.jpg";
var imgArray = [
  "img/ace-clubs.jpg",
  "img/ace-clubs.jpg",
  "img/ace-diamonds.jpg",
  "img/ace-diamonds.jpg",
  "img/jack-clubs.jpg",
  "img/jack-clubs.jpg",
  "img/jack-diamonds.jpg",
  "img/jack-diamonds.jpg",
  "img/joker.jpg",
  "img/joker.jpg",
  "img/king-clubs.jpg",
  "img/king-clubs.jpg",
  "img/king-diamonds.jpg",
  "img/king-diamonds.jpg",
  "img/queen-clubs.jpg",
  "img/queen-clubs.jpg",
  "img/queen-diamonds.jpg",
  "img/queen-diamonds.jpg",
];

//Shuffle
imgArray.sort(function() { return 0.5 - Math.random() });

$(document).ready(function(){

  $('.card').addClass('faceDown');
  var closing = false;

  $(".faceDown").click(function(){

    //WTF!?
    if($(this).attr("class") == "card faceDown" && !closing) {

      var imgIndex = $(this).index();
      $(this).find('img').attr("src", imgArray[imgIndex]);
      $(this).removeClass('faceDown');
      $(this).addClass('faceUp');


      var numFaceUp = $('.faceUp').size();
      if(numFaceUp == 2) {

        var firstSrc = $('.faceUp:first').find('img').attr("src");
        var secondSrc = $('.faceUp:last').find('img').attr("src");

        if(firstSrc != secondSrc){

          closing = true;
          setTimeout(function(){
            $('.faceUp:first').find('img').attr("src", back);
            $('.faceUp:first').addClass('faceDown');
            $('.faceUp:first').removeClass('faceUp');


            $('.faceUp:last').find('img').attr("src", back);
            $('.faceUp:last').addClass('faceDown');
            $('.faceUp:last').removeClass('faceUp');
            closing = false;
          }, 700);

        }

        else{
          $('.faceUp:first').removeClass('faceUp');

          $('.faceUp:last').removeClass('faceUp');

        }
    }
  }


  });
});
