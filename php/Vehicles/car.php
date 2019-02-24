<?php

require_once "vehicle.php";

class Car extends Vehicle
{
	public $seats;
	public $passengers = 0;

	public function __construct($s,$a,$b)
	{
		$this->seats = $s;
		parent::__construct($a,$b);
	}

	public function addP($numP)
	{
		if($this->passengers + $numP <= $this->seats )
		{
				$this->passengers += $numP;
		}
		else
		{
			if($this->passengers < $this->seats )
			{
				$temp = $this->seats - $this->passengers;
				echo "<br>Not enough space! We managed to pick up only ". $temp . " passengers!<br>";
				$this->passengers = $this->seats;
		  }
			else
			{
				echo "<br>Not enough space!<br>";
			}
		}
	}


	public function kickP($numP)
	{
		if($this->passengers >= $numP )
		{
				$this->passengers -= $numP;
		}
		else
		{
			if($this->passengers == 0)
			{
				echo "<br>We don't have passengers!<br>";
		  }
			else
			{
				echo "<br>We kicked " . $this->passengers . " passengers, and now the car is empty!<br>";
				$this->passengers = 0;
			}
		}
	}

}

?>
