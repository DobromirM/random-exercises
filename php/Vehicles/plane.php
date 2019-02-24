<?php

  require_once "vehicle.php";

  class Plane extends Vehicle
  {
    public $ammo;
    public $hp;
    public $damage = 0;
    public $wings = 2;

    function __construct($am, $h, $a, $b)
  	{
  		$this->ammo = $am;
  		$this->hp = $h;
      parent::__construct($a,$b);
  	}

    public function shoot($bulletNum)
    {
      if($this->ammo >= $bulletNum)
      {
        $this->ammo -= $bulletNum;


        $hits = 0;

        while($bulletNum > 0)
        {
          $hits += rand(0,1);
          $bulletNum -= 10 ;
        }

        if($hits != 0)
        {
          echo "<br>You hit the enemy plane and did " . $hits . " points of damage!<br>";
        }

        else
        {
          echo "<br>You missed!<br>";
        }
      }


      else
      {
        echo "<br>Not enough ammo!<br>";
      }


    }

    public function dodge()
    {
      if(rand(0,1))
      {
        echo "<br>You dodged successfuly!<br>";
      }
      else
      {

        $temp = rand(1, $this->hp / 2 );
        echo "<br>You were hit and lost ". $temp. " HP!<br>";
        $this->damage += $temp;
      }

      if($this->damage > $this->hp / 2 && $this->wings == 2)
      {
        echo "<br>You lost a wing!<br>";
        $this->wings = 1;
      }

      if($this->damage >= $this->hp)
      {
        echo "<br>Critical Levels! Destruction is Imminent!<br>";

      }
    }

    public function special()
    {
      echo "<br>Do A Barell Roll!<br>";
    }

  }

?>
