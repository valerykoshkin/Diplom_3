# Diplom_3

# Дипломная работа, часть 3

## Технологии на проекте
Java 11

Junit 4.13.2

Selenium 4.14.1

Allure 2.15.0

Rest-assured 5.3.0

Gson 2.8.9

Поддерживается запуск тестов в Яндекс.Браузере. 

Для запуска выполнить команду в терминале:

mvn clean test -Dbrowser=yandex (Для запуска всех тестов)

mvn clean test -Dbrowser=yandex -Dtest=LKTests(Для запуска конкретного класса)
