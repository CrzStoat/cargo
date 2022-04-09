##Запуск проекта

1. docker-compose up -d
2. Выполнить команды из файла cassandraInit.txt
3. Запустить CargoClientApiApplication
4. Запустить CargoProcessorApplication
5. Запустить CargoAsyncGatewayApplication
6. Запустить CargoEmulatorApplication (Если нужна эмуляция трафика)
7. Запустить из директории ./cargo-client-front
- npm install
- npm start

http://localhost:3000/login
user/user




##Суть проекта
Тестовый проект мониторинга датчиков автомобиля

Две БД. 
- Postgres (docker mypostgres) для хранения данных сервиса.
- Cassandra (docker mycassandra) для хранения значения каждого датчика (пара id_датчика/value_датчика)

Сервис CargoClientApiApplication - клиентский веб-сервис

Сервис CargoProcessorApplication - процессор, отвечающий за последовательное изменение значений датчика

Сервис CargoAsyncGatewayApplication - сервис, асинхронно принимающий значения датчиков

CargoEmulatorApplication - эмулятор трафика (для тестирования системы)

##Сценарий использования
1. CargoAsyncGatewayApplication асинхронно принимает ключ/значение (SensorEvent) датчика по http (/api/post). В качестве авторизации используется Api-key
2. CargoAsyncGatewayApplication пересылает в топик кафки SensorEvent
3. CargoProcessorApplication последовательно вычитывает из топика кафки SensorEvent'ы и обновляет запись в кассандре
4. Пользователь проходит авторизацию, получает в ответ JwtToken (от CargoClientApiApplication)
5. Пользователь запрашивает информацию по датчикам, передав JwtToken, количество датчиков на одну страницу, номер страницы
6. CargoClientApiApplication возвращает пользователю датчики и их значения под заданные настройки пагинации
