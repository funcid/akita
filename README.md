# Akita Smart Home Integration

Интеграция с платформой умного дома Яндекса для управления световыми устройствами (включение/выключение, смена цвета).
Как будут появляться идеи - буду расширять.

## Возможности
- Получение списка световых устройств пользователя
- Включение/выключение лампочек
- Управление цветом лампочек (HSV)

## Используемые технологии
- Kotlin + Spring Boot
- OpenFeign для интеграции с API Яндекса
- JUnit для тестирования

## Быстрый старт

### 1. Получение OAuth-токена Яндекса
Для работы с API Яндекса необходим OAuth-токен с правами `iot:view` и `iot:control`.

**Как получить токен вручную:**
1. Зарегистрируйте приложение в [Яндекс OAuth](https://oauth.yandex.ru/client/new).
2. В настройках приложения укажите Redirect URI:  
   `https://oauth.yandex.ru/verification_code`
3. Перейдите по ссылке:  
   `https://oauth.yandex.ru/authorize?response_type=token&client_id=<ваш_client_id>`
4. Разрешите доступ и скопируйте токен из адресной строки после `#access_token=...`

Подробнее: [Документация Яндекс ID — Получение токена вручную](https://yandex.ru/dev/id/doc/ru/tokens/debug-token)

### 2. Настройка переменных окружения
В `.env` или через конфигурацию `application.properties` укажите:
```shell
YANDEX_API_SECRET_KEY=<ваш токен>
```

### 3. Запуск приложения
```bash
./gradlew bootRun
```

### 4. Тестирование
В проекте есть интеграционные тесты (`AkitaApplicationTests.kt`), которые:
- Получают список лампочек
- Включают/выключают лампочки
- Меняют цвет лампочек

Запуск тестов:
```bash
./gradlew test
```

## Пример использования API

### Получение информации о пользователе
```http
GET https://api.iot.yandex.net/v1.0/user/info
Authorization: Bearer <ваш_oauth_token>
```

### Управление цветом лампочки
```http
POST https://api.iot.yandex.net/v1.0/devices/actions
Authorization: Bearer <ваш_oauth_token>
Content-Type: application/json

{
  "devices": [
    {
      "id": "device-id",
      "actions": [
        {
          "type": "devices.capabilities.color_setting",
          "state": {
            "instance": "rgb",
            "value": 2263842
          }
        }
      ]
    }
  ]
}
```
Подробнее: [Документация Яндекс Умный дом — Протокол управления устройствами](https://yandex.ru/dev/dialogs/smart-home/doc/ru/concepts/platform-protocol)

## Полезные ссылки
- [Яндекс Умный дом: Протокол управления устройствами](https://yandex.ru/dev/dialogs/smart-home/doc/ru/concepts/platform-protocol)
- [Яндекс ID: Получение токена вручную](https://yandex.ru/dev/id/doc/ru/tokens/debug-token) 