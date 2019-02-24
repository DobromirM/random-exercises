<?php

require_once "vehicle.php";

class Truck extends Vehicle
{
	public $maxLoad;
	public $currentLoad = 0;


	public function __construct($ml,$a,$b)
	{
		$this->maxLoad = $ml;
		parent::__construct($a,$b);
	}

	public function load($weight)
	{
		if($this->currentLoad + $weight <= $this->maxLoad )
		{
				$this->currentLoad += $weight;
		}
		else
		{
			if($this->currentLoad < $this->maxLoad )
			{
				$temp = $this->maxLoad - $this->currentLoad;
				echo "<br>Not enough space! We managed to load only ". $temp . " Kg!<br>";
				$this->currentLoad = $this->maxLoad;
		  }
			else
			{
				echo "<br>Not enough space!<br>";
			}
		}
	}


	public function unload($weight)
	{
		if($this->currentLoad >= $weight )
		{
				$this->currentLoad -= $weight;
		}
		else
		{
			if($this->currentLoad == 0)
			{
				echo "<br>The truck is empty!<br>";
		  }
			else
			{
				echo "<br>We unloaded " . $this->currentLoad . " Kg, and now the truck is empty!<br>";
				$this->currentLoad = 0;
			}
		}
	}


}

?>
