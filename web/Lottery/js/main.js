function randomInteger(min,max){
    return Math.floor(Math.random()*(max-min+1)+min);
}

function randomUniqueNumber(min,max,used){
  var arrLength = used.length;
  while(arrLength == used.length){
    var tempNumber = randomInteger(min,max);
    if(used.indexOf(tempNumber) == -1){
      used[used.length] = tempNumber;
    }
  }
  return used;
}

var luckyNumbers = Array();
var numberCount = 0;



document.addEventListener("DOMContentLoaded", function() {
  var button = document.querySelector('.button');
  var numbers = document.querySelectorAll('.number');

  button.addEventListener("click", function(){
    if(numberCount < 6){
      numbers[numberCount].getElementsByTagName('img')[0].src = "images/ball.png";
      var temp = randomUniqueNumber(1,42,luckyNumbers)[numberCount];
      if (temp < 10){
      numbers[numberCount].getElementsByClassName('text')[0].innerHTML =  "&nbsp" + randomUniqueNumber(1,42,luckyNumbers)[numberCount];
      }
      else{
      numbers[numberCount].getElementsByClassName('text')[0].innerHTML =  randomUniqueNumber(1,42,luckyNumbers)[numberCount];
      }
      numberCount++;
    }
  });

});
