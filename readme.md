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