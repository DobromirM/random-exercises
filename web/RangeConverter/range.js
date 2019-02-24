$('document').ready(function(){

	$("#calculate").click(function(){

		var left = $("#rangeLeft").val();
		var right = $("#rangeRight").val();

		if(isPositiveInt(left))
		{
			$("#left").hide();
			
			if(!right.trim())
			{
				right = parseInt(left) + 9;
			}
			
			if(isPositiveInt(right) || right == 0)
			{
				$("#right").hide();
				populateTable(parseInt(left), parseInt(right));
			}
			else
			{
				$("#right").show();
			}
			
		}
		else
		{
			$("#right").hide();
			$("#left").show();
		}

	});

	function isPositiveInt(input)
	{
		if($.isNumeric(input))
		{ 
			var number = parseFloat(input);

			if(Math.floor(number) === number)
			{
				if(number > 0)
				{
					return 1;
				}
			}
		}
		
		return 0;
	}

	function populateTable(left, right)
	{
		$("#unit-from").text($("#unit :selected").text());
		$("#unit-to").text($("#unit option:not(:selected)").text());

		$("tbody").html("");

		if(left < right)
		{
			for(i = left; i <= right; i++)
			{
				$("tbody").append("<tr><td>" + i + "</td><td>" + convert(i).toFixed(2) + "</td></tr>");
			}
		}
		else
		{
			for(i = left; i >= right; i--)
			{
				$("tbody").append("<tr><td>" + i + "</td><td>" + convert(i).toFixed(2) + "</td></tr>");
			}
		}

		$("table").css("visibility", "visible");
	}

	function convert(number)
	{
		if($("#unit").val() == "km")
		{
			return number / 1.609;
		}
		else
		{
			return number * 1.609;
		}
	}

});