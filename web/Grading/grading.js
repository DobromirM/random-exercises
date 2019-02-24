$('document').ready(function(){

	var form = [
				{section:"Dynamic Table", points:20}, 
				{section:"Intellij Usage", points:10},
				{section:"Calendar Control", points:30},
				{section:"Active Form", points:20},
				{section:"Object Database", points:20}
			   ];

	initForm(form);

	$(".mark").change(function(){

		var total = 0;

		$(".mark").each(function(){

			total = total + parseInt($(this).find('option:selected').val());

		});

		$("#total").val(total);

	});
	

	$("#clear").click(function(){

		$("form")[0].reset();

	});

	function initForm(form)
	{

		for(i = 0; i < form.length; i++)
		{
			var row = form[i];

			var name = "<td class='name'>" + row.section + "</td>";
			var max = "<td class='max'>" + row.points + "</td>";
			var comment = "<td class='comments'><textarea rows='4' cols='50'></textarea></td>";
			var mark = "<td class='mark'><select name='mark'>";

			for(j = 0; j <= row.points; j++)
			{
				mark = mark + "<option value='" + j + "'>" + j + "</option>";
			}

			mark = mark + "</select></td>";

			var rowHtml = "<tr id='row-" + i + "'>" + name + max + comment + mark + "</tr>"

			$("tbody").append(rowHtml);

			$(".comments textarea").each(function(){
				$(this).val("Enter Comments");
			});
		}
		
	}

});