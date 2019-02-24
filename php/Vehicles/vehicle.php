<?php

class Vehicle
{
	public $color;
	public $fuel;
	public $position = 0;

	function __construct($a, $b)
	{
		$this->fuel = $a;
		$this->color = $b;
	}

	public function move($distance)
	{
		$this->fuel = $this->fuel - $distance/10;
		$this->position = $this->position + $distance;
	}


}
?>
