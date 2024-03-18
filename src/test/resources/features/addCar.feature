Feature: Add Car

  @positive
  Scenario: Add a car to rent out
    Given User launches Chrome Browser
    When User opens ilcarro Home Page
    And User clicks on the Add Car button
    And User enters car details as follows:
      | Field                   | Value             |
      | Location                | Haifa, Israel     |
      | Manufacture             | BMW               |
      | Model                   | I3                |
      | Year                    | 2022              |
      | Fuel                    | Electric          |
      | Seats                   | 4                 |
      | Car class               | Rex               |
      | Car registration number | 555               |
      | Price                   | 24998             |
      | About                   | Electric motor characteristics – 170 hp. and 250 Nm. It allows the BMW i3 (94 Ah) REX to accelerate from zero to 100 km |
    And User uploads photos of the car
    And User clicks on the Submit button
    Then User verifies that the car is successfully added
    And User quites browser