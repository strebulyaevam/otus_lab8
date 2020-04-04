Feature: I can use  habr.com top bar to get the content

  Scenario: Open habr.com home page
    When HomePage is open
    Then page title should be "Лучшие публикации за сутки / Хабр"


  Scenario: Top bar is on the home page
    Given HomePage is open
    When Top bar is opened
    Then Top bar contains items
           | Все потоки        |
           | Разработка        |
           | Научпоп           |
           | Администрирование |
           | Дизайн            |
           | Менеджмент        |
           | Маркетинг         |



  Scenario: First item of Top bar is selected
       Given HomePage is open
       When Top bar is opened
       Then Top bar item "Все потоки" is selected


  Scenario Outline: Click TopBar tab "<name>"
       Given HomePage is open
       When Top bar item "<name>" is clicked
       Then Top bar item "<name>" is selected
       And Title contains "<name>"
       Examples:
          | name              |
          | Разработка        |
          | Научпоп           |
          | Администрирование |
          | Дизайн            |
          | Менеджмент        |
          | Маркетинг         |


  Scenario: Button "Войти" dispaly the correct page
       Given HomePage is open
       And Top bar is opened
       When button Войти is clicked
       Then LoginPage is displayed


  Scenario: Button "Регистрация" dispaly the correct page
       Given HomePage is open
       And Top bar is opened
       When button Регистрация is clicked
       Then RegistrationPage is displayed