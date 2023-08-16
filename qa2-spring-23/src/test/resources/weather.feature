Feature: Weather forecast
  Scenario: Full weather info checks
    Given city ID is 12345

    When we are requesting weather forecast

    Then latitude is 31.39
    And longitude is -74.5
    And timezone is "America/New_York"
    And timezone offset is -18000

    And current dt is 1646318698
    And current sunrise is 1646306882
    And current sunset is 1646347929
    And current temp is 282.21
    And current feels like is 278.41
    And current pressure is 1014
    And current humidity is 65
    And current dew point is 275.99
    And current uvi is 2.55
    And current clouds are 40
    And current visibility is 10000
    And current wind speed is 8.75
    And current wind deg is 360
    And current wind gust is 13.89
    And current wearter id is 802
    And current weather main is "clouds"
    And current weather description is "scattered clouds"
    And current weather icon is "03d"

    And minutely dt is 1646318700
    And minutely precipitation is 0

    And hourly dt is 1646316000
    And hourly temp is 281.94
    And hourly feels like is 278.49
    And hourly pressure is 1014
    And hourly humidity is 67
    And hourly dew point is 276.16
    And hourly uvi is 1.49
    And hourly clouds are 52
    And hourly vidibility is 10000
    And hourly wind speed is 7.16
    And hourly wind deg is 313
    And hourly wind gust is 10.71
    And hourly weather id is 803
    And hourly weather main is "clouds"
    And hourly weather description is "broken clouds"
    And hourly weather icon is "04d"
    And hourly pop is 0.03

    And daily dt is 1646326800
    And daily sunrise is 1646306882
    And daily sunset is 1646347929
    And daily moonrise is 1646309880
    And daily moonset is 1646352120
    And daily moon phase is 0.03
    And daily day temp is 281.63
    And daily min temp is 271.72
    And daily max temp is 282.21
    And daily night temp is 271.72
    And daily eve temp is 277.99
    And daily morn temp is 280.92
    And daily day temp feels like 277.83
    And daily night temp feels like 264.72
    And daily eve temp feels like 273.35
    And daily morn temp feels like 277.66
    And daily pressure is 1016
    And daily humidity is 55
    And daily dew point is 273.12
    And daily wind speed is 9.29
    And daily wind deg is 3
    And daily wind gust is 16.48
    And daily weather id is 500
    And daily weather main is "rain"
    And daily weather description is "light rain"
    And daily weather icon is "10d"
    And daily clouds are 49
    And daily pop is 0.25
    And daily rain is 0.11
    And daily uvi is 3.38

    And alerts senders name is "NWSPhiladelphia-MountHolly(NewJersey,Delaware,SoutheasternPennsylvania)"
    And alerts event is "SmallCraftAdvisory"
    And alerts start is 1646344800
    And alerts end is 1646380800
    And alerts description is ..."SMALLCRAFTADVISORYREMAINSINEFFECTFROM5PMTHISAFTERNOONTO3AMESTFRIDAY...*WHAT...Northwinds15to20ktwithgustsupto25ktandseas3to5ftexpected.*WHERE...CoastalwatersfromLittleEggInlettoGreatEggInletNJout20nm,CoastalwatersfromGreatEggInlettoCapeMayNJout20nmandCoastalwatersfromManasquanInlettoLittleEggInletNJout20nm.*WHEN...From5PMthisafternoonto3AMESTFriday.*IMPACTS...Conditionswillbehazardoustosmallcraft."
    And alerts tags are empty








