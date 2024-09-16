<h1>Java Spring Backend</h1>

<h2>Контроллеры</h2>
ВАЖНО!

Наш сервер безупречен. Если у вас что-то не работает, вините только себя. У нас здесь всё функционирует идеально, каждую секунду, без исключений.

Проблемы? Это ваши интернет-соединения, устройства или кривые настройки. Мы не будем нести ответственность за ваши ошибки, тормоза и глюки. Всё, что происходит на вашей стороне, — это ваша головная боль.

Ещё раз: наш сервер в полном порядке. Если что-то сломано, это сломано у вас!

<h2>Страны /countries</h2>
    
GET /countries - вывод всех стран

GET /countries/{id} - вывод страны по id

POST /countires?Name=**NAME** - добавление страны

- NAME - название страны. String, 50

PUT /countires/{id}?Name=**NAME** - редактирование страны

- NAME - название страны. String, 50

DELETE /countires/{id} - удаление страны



<h2>Офисы /offices</h2>

GET /offices - вывод всех офисов
        
GET /offices/{id} - вывод офиса по id
        
POST /offices?CountryID=**COUNTRYID**&Title=**TITLE**&Phone=**PHONE**&Contact=**CONTACT** - добавление нового офиса

- COUNTRYID - id страны. Integer
- TITLE - название офиса. String, 50
- PHONE - номер телефона. String, 50
- CONTACT - главный в офсие. String, 150

PUT /offices/{id}?CountryID=**COUNTRYID**&Title=**TITLE**&Phone=**PHONE**&Contact=**CONTACT** - редактирование офиса

- COUNTRYID - id страны. Integer
- TITLE - название офиса. String, 50
- PHONE - номер телефона. String, 50
- CONTACT - главный в офсие. String, 150

DELETE /offices/{id} - удаление офиса по id



<h2>Роли /roles</h2>

GET /roles - вывод всех ролей

GET /roles/{id} - вывод роли по id


<h2>Пользователи /users</h2>

GET /users - вывод всех пользователей

GET /users/{id} - вывод пользователя по id

GET /users/verify?Email=**EMAIL**&Password=**PASSWORD**

- EMAIL - email. String, 150
- PASSWORD - пароль. String, 50
Ответы верификации:
- ACCESS ACCEPT - правильный логин и пароль, блокирововок нет
- ACESS DENIED: **blocking reason** - пользователь заброкирован, выводится причина блокировки
- INCORRECT PASSWORD - верный email, неверный пароль
- USER NOT FOUND - неверный email

POST /users?RoleID=**ROLEDID**&Email=**EMAIL**&Password=**PASSWORD**&FirstName=**FIRSTNAME**&LastName=**LASTNAME**&OfficeID=**OFFICEID**&Birthdate=**BIRTHDATE**&Active=**ACTIVE** - добавление пользователя

- ROLEID - id роли. Integer
- EMAIL - email. String, 150
- PASSWORD - пароль. String, 50
- FIRSTNAME - имя. String, 50
- LASTNAME - фамилия. String, 50
- OFFICEID - id офиса, integer
- BIRTHDATE - дата рождения. dd-mm-yyyy
- ACTIVE - онлайн или нет, видимо. Boolean

PUT /users/{id}?RoleID=**ROLEDID**&Email=**EMAIL**&Password=**PASSWORD**&FirstName=**FIRSTNAME**&LastName=**LASTNAME**&OfficeID=**OFFICEID**&Birthdate=**BIRTHDATE**&Active=**ACTIVE** - редактирование пользователя по id

- ROLEID - id роли, не требуется. integer
- EMAIL - email , не требуется. String, 150
- PASSWORD - пароль, не требуется. String, 50
- FIRSTNAME - имя, не требуется. String, 50
- LASTNAME - фамилия, не требуется. String, 50
- OFFICEID - id офиса, не требуется. Integer
- BIRTHDATE - дата рождения, не требуется. dd-mm-yyyy
- ACTIVE - онлайн или нет, видимо, не требуется. Boolean

DELETE /users/{id} - удаление пользователя по id

<h2>Пользовательские логи /usersinfo</h2>

GET /usersinfo - вывод логов всех пользователей

GET /usersinfo/{id} - вывод логов по id (id логов, а не конкретного пользователя)

POST /usersinfo?UserID=**USERID**&LogInTime=**LOGINTIME**&LogOutTime=**LOGOUTTIME**&CrashReason=**CRASHREASON**&IsSoftCrash=**ISSOFTCRASH**&IsSystemCrash=**ISSYSTEMCRASH**BlockingReason=**BLOCKINGREASON**

- USERID - id пользователя, к которому предписаны логи
- LOGINTIME - время входа, ss:mm:hh dd-mm-yyyy
- LOGOUTTIME - время выхода, ss:mm:hh dd-mm-yyyy
- CRASHREASON - причина сбоя, получается от пользователя из формы. String, 200, не задавать или NULL при отсутствии
- ISSOFTCRASH - в софте ли причина сбоя, получается от пользователя из формы. Boolean, не задавать или NULL при отсутствии
- ISSYSTEMCRASH - в системе ли причина сбоя, получается от пользователя из формы. Boolean, не задавать или NULL при отсутствии
- BLOCKINGREASON - причина блокировки. При наличии польщователь считается заблокированным, не пройдёт верификацию. String, 200, не задавать или NULL при отсутствии

PUT /usersinfo/{id}?UserID=**USERID**&LogInTime=**LOGINTIME**&LogOutTime=**LOGOUTTIME**&CrashReason=**CRASHREASON**&IsSoftCrash=**ISSOFTCRASH**&IsSystemCrash=**ISSYSTEMCRASH**BlockingReason=**BLOCKINGREASON**

- USERID - id пользователя, к которому предписаны логи. Integer
- LOGINTIME - время входа. ss:mm:hh dd-mm-yyyy
- LOGOUTTIME - время выхода. ss:mm:hh dd-mm-yyyy
- CRASHREASON - причина сбоя, получается от пользователя из формы. String, 200, не задавать или NULL при отсутствии
- ISSOFTCRASH - в софте ли причина сбоя, получается от пользователя из формы. Boolean, не задавать или NULL при отсутствии
- ISSYSTEMCRASH - в системе ли причина сбоя, получается от пользователя из формы. Boolean, не задавать или NULL при отсутствии
- BLOCKINGREASON - причина блокировки. При наличии польщователь считается заблокированным, не пройдёт верификацию. String, 200, не задавать или NULL при отсутствии

DELETE /usersinfo/{id} - удаление логов по id логов