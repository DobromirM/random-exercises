<html>
	<head>
		<link rel='stylesheet' type='text/css' href='css/main.css' />
	</head>
	<body>
		
		
		
<?php
  // echo "<link rel='stylesheet' type='text/css' href='css/main.css' />";
	 echo"<pre>";

   $items = Array(

   		0=> Array(
				"price"=> "450",
				"quantity"=> "20",
        "description"=> Array(
          "year"=> "2013",
          "brand"=> "Toshiba",
          "model"=> "Satellite CL10",
          "ram"=> "2048",
          "cpu"=> "Intel Celeron N3050 1.60 GHz",
          "warranty"=> "24",
        )
		  ),


      1=> Array(
        "price"=> "412",
        "quantity"=> "50",
        "description"=> Array(
          "year"=> "2012",
          "brand"=> "Acer",
          "model"=> "Aspire ES1-131",
          "ram"=> "2048",
          "cpu"=> "Intel Celeron N3050 1.60 GHz",
          "warranty"=> "12",
        )
      ),

      2=> Array(
        "price"=> "600",
        "quantity"=> "12",
        "description"=> Array(
          "year"=> "2013",
          "brand"=> "Lenovo",
          "model"=> "Ideapad B51",
          "ram"=> "4096",
          "cpu"=> "Intel Celeron N3050 1.60 GHz",
          "warranty"=> "24",
        )
      )

   );

   $items[3]["price"] = "499";
   $items[3]["quantity"] = "0";
   $items[3]["description"]["year"] = "2013";
   $items[3]["description"]["brand"] = "Asus";
   $items[3]["description"]["model"] = "X205TA";
   $items[3]["description"]["ram"] = "2048";
   $items[3]["description"]["cpu"] = "Intel Atom Z3735F 1.33 GHz";
   $items[3]["description"]["warranty"] = "6";

   $items[4]["price"] = "558";
   $items[4]["quantity"] = "3";
   $items[4]["description"]["year"] = "2014";
   $items[4]["description"]["brand"] = "Dell";
   $items[4]["description"]["model"] = "Inspiron 3551";
   $items[4]["description"]["ram"] = "4096";
   $items[4]["description"]["cpu"] = "Intel Celeron N2840 2.16 GHz";
   $items[4]["description"]["warranty"] = "12";

   print_r($items);
   echo "</pre>";


   echo "<br><br><br><span class='title'>This is what we have in our store:</span><br><br><br>";

   echo "<div class= 'mainContainer'>";
   
   
   
   
   foreach($items as $key=>$value) {
     echo "<div class='item'>";


     	echo "<span class='name'>".$value["description"]["brand"]." ".$value["description"]["model"]." - ".$value["price"]."$</span>";


     	echo "Year of manufacture: ".$value["description"]["year"]."<br>";
     	echo "RAM: ".$value["description"]["ram"]." MB<br>";
     	echo "CPU: ".$value["description"]["cpu"]."<br>";
     	echo "Warranty: ".$value["description"]["warranty"]." Months<br>";

	     if($value["quantity"] == "0"){
	       echo "No items left in store<br>";
	     }
	     else {
	       echo $value["quantity"]." items left in store<br>";
	     }

     echo "</div>";
   }
   
   
   
   
   
   echo "</div>";


?>
		
		
		
	</body>
</html>

