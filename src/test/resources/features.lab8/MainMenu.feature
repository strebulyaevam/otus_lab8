Feature: I can use  habr.com main menu to get the content

  Scenario: Main menu is on the home page
    When HomePage is open
    Then Main menu contains items
           | СТАТЬИ   |
           | НОВОСТИ  |
           | ХАБЫ     |
           | АВТОРЫ   |
           | КОМПАНИИ |


  Scenario: First item of Main menu is selected
       Given HomePage is open
       When Main Menu is opened
       Then Main menu item "Статьи" is selected


  Scenario Outline: Click MainMenu tab "<name>"
       Given HomePage is open
       When Main menu item "<name>" is clicked
       Then Main menu item "<name>" is selected
       Examples:
           | name     |
           | Статьи   |
           | Новости  |
           | Хабы     |
           | Авторы   |
           | Компании |


  Scenario: Click on Статьи menu dispaly the correct page
       Given HomePage is open
       And Main Menu is opened
       When Main menu item "Статьи" is clicked
       Then ArticlesPage is displayed