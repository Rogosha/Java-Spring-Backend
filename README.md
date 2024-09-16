<h1>Java Spring Backend</h1>

<h2>Важная информация</h2>
<h3>ВАЖНО!</h3>

Наш сервер безупречен. Если у вас что-то не работает, вините только себя. У нас здесь всё функционирует идеально, каждую секунду, без исключений.
Проблемы? Это ваши интернет-соединения, устройства или кривые настройки. Мы не будем нести ответственность за ваши ошибки, тормоза и глюки. Всё, что происходит на вашей стороне, — это ваша головная боль.
Ещё раз: наш сервер в полном порядке. Если что-то сломано, это сломано у вас!

<h3>КРАЙНЕ ВАЖНО!</h3>

- запросы POST требуют объект **без** поля id, id назначает БД
- запросы PUT требуют объект **с** полем id, идентифицируя по нему редактируемое
- после каждого заголовка контроллера есть формат объекта и описание полей, также отмечены обязательные поля. 
- Важно использовать объекты в тех полях, где они требуются
- в запросах PUT можно не указывать даже обязательные поля

<h2>Страны /countries</h2>

<h3>Объект:</h3>
{
  "id": 1,
  "name": "Afghanistan"
}

<h3>Поля: </h3>
- name - название страны. String, 50, обязательное поле

<h3>Запросы: </h3>
GET /countries - вывод всех стран, возвращает массив

GET /countries/{id} - вывод страны по id, возвращает один объект 

POST /countries - добавление страны, возвращает id добавленного

PUT /countries - редактирование страны, выбор редактируемой записи по id в объекте, возвращает **OK** или **NOT_OK**

DELETE /countries/{id} - удаление страны



<h2>Офисы /offices</h2>

<h3>Объект:</h3>

{
    "id": 1,
    "country": { 
    },
    "title": "Abu dhabi",
    "phone": "638-757-8582\r\n",
    "contact": "MIchael Malki"
}

<h3>Поля: </h3>
- county - объект страны, обязательное поле
- title - название офиса. String, 50, обязательное поле
- phone - номер телефона. String, 50, обязательное поле
- contact - главный в офсие. String, 150, обязательное поле

<h3>Запросы: </h3>

GET /offices - вывод всех офисов

GET /offices/{id} - вывод офиса по id

POST /offices - добавление нового офиса, возвращает id добавленного

PUT /offices - редактирование офиса, выбор редактируемой записи по id в объекте, возвращает **OK** или **NOT_OK**

DELETE /offices/{id} - удаление офиса по id, возвращает **OK** или **NOT_OK**



<h2>Роли /roles</h2>

<h3>Объект:</h3>
{
    "id": 1,
    "title": "Administrator"
}

<h3>Запросы: </h3>
GET /roles - вывод всех ролей

GET /roles/{id} - вывод роли по id

<h2>Пользователи /users</h2>

<h3>Объект:</h3>
{
    "id": 1,
    "role": { 
    },
    "email": "j.doe@amonic.com",
    "firstName": "John",
    "lastName": "Doe",
    "office": { 
    },
    "birthdate": "1983-01-13",
    "active": true
}

<h3>Поля: </h3>
- role - объект роли, обязательное поле
- email. String, 150, обязательное поле
- password - String, 50, обязательное поле
- firstName - имя. String, 50
- lastName - фамилия. String, 50, обязательное поле
- office - объект офиса
- birthdate - дата рождения. yyyy-mm-dd
- active - онлайн или нет, видимо. Boolean

<h3>Запросы: </h3>
GET /users - вывод всех пользователей, возвращает массив пользователей

GET /users/{id} - вывод пользователя по id, возвращает объект

GET /users/verify - верификация, на вход объект со следующими полями:
{
    "email": "j.doe@amonic.com",
    "password": "123"
}

- email. String, 150, обязательное поле
- password - пароль. String, 50, обязательное поле
  
<h4>Ответы верификации:</h4>
  
- ACCESS ACCEPT - правильный логин и пароль, блокирововок нет
- ACCESS DENIED: **blockingReason** - пользователь заброкирован, выводится причина блокировки
- INCORRECT PASSWORD - верный email, неверный пароль
- USER NOT FOUND - неверный email

POST /users - добавление пользователя

PUT /users - редактирование пользователя по id, выбор редактируемой записи по id в объекте, возвращает **OK** или **NOT_OK**

DELETE /users/{id} - удаление пользователя по id

<h2>Пользовательские логи /usersinfo</h2>

<h3>Объект:</h3>
{
    "user": { 
    },
    "logInTime": "2000-12-03T12:59:00",
    "logOutTime": "2001-12-03T12:59:00",
    "crashReason": "anabolici",
    "softwareCrash": true,
    "systemCrash": true
}

<h3>Поля: </h3>
- user - объект пользователя, которому предписаны логи, обязательное поле
- logInTime - время входа, ss:mm:hh dd-mm-yyyy
- logOutTime - время выхода, ss:mm:hh dd-mm-yyyy
- crashReason - причина сбоя, получается от пользователя из формы. String, 200, не задавать или NULL при отсутствии
- isSoftCrash - в софте ли причина сбоя, получается от пользователя из формы. Boolean, не задавать или NULL при отсутствии
- isSystemCrash - в системе ли причина сбоя, получается от пользователя из формы. Boolean, не задавать или NULL при отсутствии

<h3>Запросы: </h3>
GET /usersinfo - вывод логов всех пользователей, возвращает массив

GET /usersinfo/{id} - вывод логов по id (id логов, а не конкретного пользователя), возвращает один объект

POST /usersinfo

PUT /usersinfo - редактирование логов, выбор редактируемой записи по id в объекте, возвращает **OK** или **NOT_OK**

DELETE /usersinfo/{id} - удаление логов по id логов


<h2>Блокировки /countries</h2>

<h3>Объект:</h3>
{
    "id": 1,
    "user": { 
    },
    "blockingReason": "he is really bad guy"
}

<h3>Поля: </h3>
- user - объект пользователя, которому предписана блокировка, обязательное поле
- blockingReason - причина блокировки. String, 200, обязательное поле

<h3>Запросы: </h3>
GET /usersblocking - вывод всех записей о блокировках, возвращает массив

GET /usersblocking/{id} - вывод причины блокировки по id, возвращает один объект

POST /usersblocking - добавление причины блокировки, возвращает id добавленного

PUT /usersblocking - редактирование статуса блокировки, выбор редактируемой записи по id в объекте, возвращает **OK** или **NOT_OK**

DELETE /usersblocking/{id} - удаление статуса блокировки по id блокировки