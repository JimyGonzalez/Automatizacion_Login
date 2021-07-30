Feature: Login into the application

  Scenario: Successful login
    Given correo@gmail.com has an active account
    When he send their valid credentials
    Then he should have access to manage his account