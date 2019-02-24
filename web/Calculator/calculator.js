$('document').ready(function(){

    var number = "";
    var operator = "";
    var memoryNum;
    var memoryClear = false;
    
    $(".digit").click(function () {
    
        if (number.length <= 9)
        {
            if (number[0] === "0" && number.indexOf('.')  === -1)
            {
                number = number.substring(1);
            }
            
            number = number + $(this).text();
            $(".box").text(number);
        }
    
        memoryClear = false;
        
    });
    
    $(".clear").click(function () {
        
        if (memoryClear)
        {
            memoryNum = undefined;
            operator = "";
        }
        
        number = "0";
        $(".box").text(number);
        memoryClear = true;
        
    });
    
    $(".dot").click(function () {
        
        if(number.length > 0)
        {
            if (number.indexOf('.')  === -1)
            {
                number = number + $(this).text();
                $(".box").text(number);
            }
        }
    
        memoryClear = false;
        
    });
    
    $(".operator").click(function () {
    
        if(memoryNum !== undefined && number !== "")
        {
            calc();
        }
    
        operator = $(this).text();
        
        memoryNum = Number($(".box").text());
        number = "";
        memoryClear = false;
        
    });
    
    $(".equals").click(function () {
        
        if (memoryNum !== undefined)
        {
            calc();
            number = "";
            memoryNum = undefined;
            operator = "";
            memoryClear = false;
        }
        
    });
    
    function calc() {
        
        var result = 0;
    
        switch (operator)
        {
            case "+": result = memoryNum + Number(number);break;
            case "-": result = memoryNum - Number(number);break;
            case "*": result = memoryNum * Number(number);break;
            case "/": result = memoryNum / Number(number);break;
        }
    
        if(result === Infinity)
        {
            result = NaN;
        }
    
        memoryNum = result;
    
        
        if (result.toString().length > 7)
        {
            result = result.toExponential(7)
        }
        
        $(".box").text(result);
        
    }
    
});
