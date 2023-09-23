Feature: Airplane Ticket Booking

  Scenario: Successful ticket booking
    Given airports:
      | from | RIX |
      | to   | JFC |

    And passenger info is
      | first_name | Julija |
      | last_name  | Turp   |

    And flight info is
      | discount        | CCCCCC     |
      | passenger_count | 2          |
      | children_count  | 1          |
      | luggage_count   | 3          |
      | flight_date     | 12-05-2018 |
      | seat_nr         | 17         |

    And home page is opened

    When we are selecting airports
    Then selected airports appear on the passenger info page

    When we are filling in passenger info and requesting price
    Then airports and price appear in flight details

    When we are confirming price
    And selecting seat number
    Then selected seat number appears

    When we are confirming seat
    Then successful registration message appears

    When we are requesting all reservations via API
    Then current reservation exists in the list
    And all data is stored correctly