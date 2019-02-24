<?php

function fight($firstFighter, $secondFighter)
{
	$round = 1;

	while ($firstFighter->getHP() > 0 && $secondFighter->getHP() > 0)
	{
			if($round % 2 == 0)
			{
				$firstFighter->attack($secondFighter) * rand(1,5);
				$secondFighter->attack($firstFighter) * rand(1,5);
			}

			else
			{
				$firstFighter->attack($secondFighter);
				$secondFighter->attack($firstFighter);
			}

			$round++;
	}

	echo($firstFighter->getHP()."<br>");
	echo($secondFighter->getHP()."<br>");
	if(($firstFighter->getHP() <= 0) && ($secondFighter->getHP() <= 0))
	{
		echo "Draw!";
	}
	else
	{

		if($firstFighter->getHP() > $secondFighter->getHP())
		{
			echo "Player 1 Wins!";
		}

		else
		{
			echo "Player 2 Wins!";
		}
  }

}


class lifeform
{
	protected $hp;
	protected $dmg;

	protected $critChance;

	public function attack($target)
	{
		// $superman->hp;
		// $remaining = $superman->hp - $batman->hp = 100-10

		$critModifier = 1;

		if( rand(0,100) < $this->critChance)
		{
			$critModifier = 2;
		}
		if( rand(0,1000) == 666)
		{
			$critModifier = 10;
		}
		$remaining = $target->getHP() - $this->dmg*$critModifier ;
		// $superman->setHP(90);
		$target->setHP($remaining);
	}

	public function setCritChance($c)
	{
		$this->critChance = $c;
	}

	public function getCritChance()
	{
		return $this->critChance;
	}

	public function getHP()
	{
		return $this->hp;
	}

	public function setHP($h)
	{
		$this->hp = $h;
	}

	public function __construct($a, $b)
	{
		$this->hp = $a;
		$this->dmg = $b;
	}
}
class human extends lifeform
{
	protected $utilityDamage;

	public function setUtilityDamage($s)
	{
		$this->utilityDamage = $s;
	}

	public function getUtilityDamage()
	{
		return $this->utilityDamage;
	}

	public function useBelt()
	{
		$this->dmg = $this->dmg*$this->utilityDamage;
	}
}
class kryptonian extends lifeform
{
	protected $heatRay;

	public function setHeatRay($h)
	{
		$this->heatRay = $h;
	}

	public function getHeatRay()
	{
		return $this->heatRay;
	}

	public function useHeatRay($target)
	{
		$remaining = $target->getHP() - $this->heatRay ;
		// $superman->setHP(90);
		$target->setHP($remaining);
	}
}


class mutant extends lifeform
{
	protected $rage;
	protected $healingFactor;

	public function setEnrage($r)
	{
		$this->rage = $r * rand(1,5);
	}

	public function getEnrage()
	{
		return $this->rage;
	}

	public function setHeal($h)
	{
		$this->healingFactor = $h * rand(5,10);
	}

	public function getHeal()
	{
		return $this->healingFactor;
	}

	public function enrage($target)
	{
		$this->dmg = $this->dmg * $this->rage;
	}

	public function heal($target)
	{
		$this->hp = $this->hp + $this->healingFactor;
	}
}


$wolverine = new mutant(100,10);
$wolverine->setHeal(5);
$wolverine->setEnrage(3);
$wolverine->setCritChance(5);

$batman = new human(100,10);
$batman->setUtilityDamage(1.2);
$batman->setCritChance(10);

$superman = new kryptonian(100,10);
$superman->setHeatRay(18);
$superman->setCritChance(20);



fight($superman, $wolverine);


echo "<pre>";
print_r($batman);
print_r($superman);
print_r($wolverine);

exit;
