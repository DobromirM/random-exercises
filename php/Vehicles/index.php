<?php

  require_once("car.php");
  require_once("truck.php");
  require_once("plane.php");

  echo "<pre>";

  $car = new Car(5, 300, "White");
  $truck = new Truck(50, 300, "Black");
  $plane = new Plane(2000, 25, 1000, "Grey");

  print_r($truck);
  $truck->load(20);
  print_r($truck);
  $truck->load(15);
  print_r($truck);
  $truck->load(30);
  print_r($truck);
  $truck->load(30);
  print_r($truck);

  $truck->unload(30);
  print_r($truck);
  $truck->unload(10);
  print_r($truck);
  $truck->unload(15);
  print_r($truck);
  $truck->unload(15);
  print_r($truck);

  print_r($car);
  $car->addP(2);
  print_r($car);
  $car->addP(4);
  print_r($car);
  $car->addP(2);
  print_r($car);

  $car->kickP(2);
  print_r($car);
  $car->kickP(4);
  print_r($car);
  $car->kickP(4);
  print_r($car);

  print_r($plane);
  $plane->shoot(100);
  print_r($plane);
  $plane->shoot(1900);
  print_r($plane);
  $plane->shoot(10);
  print_r($plane);

  print_r($plane);
  $plane->dodge();
  print_r($plane);
  $plane->dodge();
  print_r($plane);
  $plane->dodge();
  print_r($plane);
  $plane->dodge();
  print_r($plane);
  $plane->dodge();
  print_r($plane);

  $plane->special();
  $plane->special();
  $plane->special();
  $plane->special();
  $plane->special();

?>
