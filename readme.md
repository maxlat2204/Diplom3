# Имя
Diplome 3

## Технологии
1. **Maven** 4.0.0
2. **Java** 11 
3. **Junit** 4.13.2
4. **Rest-assured** 5.5.1
5. **Gson** 2.12.1 
6. **Selenium-java** 4.32.0
7. **Webdrivermanager** 6.1.0 
8. **Allure-junit4** 2.15.0
9. **Allure-rest-assured** 2.29.1
10. **Javafaker** 1.0.2
11. **Lombok** 1.18.38

## Запуск тестов через Хром
```bash
mvn clean test
```

## Запуск тестов через Яндекс браузер
```bash
$ mvn clean test -Dbrowser=yandex -Ddriver.version=134.0.6998.165 -Dpath.browser=C:/Users/maxla/AppData/Local/Yandex/YandexBrowser/Application/browser.exe
```

## Запустить веб-сервер Allure (отчет Allure)
```bash
mvn allure:serve
```