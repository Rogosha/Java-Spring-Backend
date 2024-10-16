# Java Spring Backend   

## Объекты   

### Aircrafts   
#### Объект:
    {     
        "id": 1,     
        "name": "Boeing 738",     
        "makeModel": "B738-1950",     
        "totalSeats": 205,     
        "businessSeats": 21,     
        "economySeats": 162     
    }     
#### Запросы:
>GET /aircrafts - возвращает массив объектов
>
>GET /aircrafts/{id} - возвращает один объект по  его id
>
>POST /aircrafts - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /aircrafts - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /aircrafts/{id} - удаляет объект по id, возвращает удалённый объект
### Airports
#### Объект:
    {     
        "id": 2,     
        "country": { COUNTRIES }          
        "name": "Abu Dhabi",     
        "iatacode": "AUH"     
    }     
#### Запросы
>
>GET /airports - возвращает массив объектов
>
>GET /airports/{id} - возвращает один объект по  его id
>
>POST /airports - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /airports - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /airports/{id} - удаляет объект по id, возвращает удалённый объект
### Amenities
#### Объект:
    {
        "id": 1,
        "service": "Extra Blanket",
        "price": 10.0
    }
#### Запросы
>GET /amenities - возвращает массив объектов
> 
>GET /amenities/ - возвращает один объект по  его id
### AmenitiesTickets
#### Объект:
    {
        "amenities": { AMENITIES },
        "tickets": { TICKETS },
        "price": 5.0
    }
#### Запросы
>
> У AmenitiesTickets составной id, это по тз, составляется из amenities и tickets. Изменение и удаление только произойдёт успешно только в объектах с этими полями
> 
>GET /amenitiestickets - возвращает массив объектов
>
>GET /amenitiestickets/{bookingReference} - возвращает один все дополнительные услуги по его номеру бронирования билета
>
>POST /amenitiestickets - помещает в базу данных переданный объект, возвращает помещённый объект
>
>PUT /amenitiestickets - редактирует объект, имеющийся в базе данных, возвращает изменённый объект или null при ошибке
>
>DELETE /amenitiestickets - удаляет объект, возвращает удалённый объект

### AmenitiesCabinType
#### Объект:
    {
        "amenities": {
            "id": 1,
            "service": "Extra Blanket",
            "price": 10.0
        },
        "cabinType": {
            "id": 2,
            "name": "Business"
        }
    },
#### Запросы
>GET /amenitiescabintypes - возвращает массив объектов

### CabinTypes
#### Объект:
    {   
        "id": 1,   
        "name": "Economy"   
    }   
#### Запросы:
>
>GET /cabintypes - возвращает массив объектов
>
>GET /cabintypes/{id
>
>POST /cabintypes - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /cabintypes - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /cabintypes/{id} - удаляет объект по id, возвращает удалённый объект

### Countries
#### Объект:
    {   
        "id": 1,   
        "name": "Afghanistan"   
    }   
#### Запросы:
>GET /countries - возвращает массив объектов
>
>GET /countries/{id} - возвращает один объект по  его id
>
>POST /countries - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /countries - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /countries/{id} - удаляет объект по id, возвращает удалённый объект


### Offices
#### Объект:
    {   
        "id": 1,   
        "country": { COUNTRIES },   
        "title": "Abu dhabi",   
        "phone": "638-757-8582\r\n",   
        "contact": "MIchael Malki"   
    }   
#### Запросы:
>GET /offices - возвращает массив объектов
>
>GET /offices/{id} - возвращает один объект по  его id
>
>POST /offices - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /offices - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /offices/{id} - удаляет объект по id, возвращает удалённый объект

### Roles   
#### Объект:
    {   
        "id": 2,   
        "title": "User"   
    }   
#### Запросы:
>GET /roles - возвращает массив объектов
>
>GET /roles/{id} - возвращает один объект по  его id

### Routes
#### Объект:
    {   
        "id": 1,   
        "departureAirport": { AIRPORTS },      
        "arrivalAirport": { AIRPORTS },      
        "distance": 453,   
    "flightTime": 64      
    }   
#### Запросы:

>GET /routes - возвращает массив объектов
>
>GET /routes/{id} - возвращает один объект по  его id
>
>POST /routes - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /routes - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /routes/{id} - удаляет объект по id, возвращает удалённый объект

### Schedules
#### Объект:
    {   
        "id": 1,   
        "date": "2017-10-04",   
        "time": "17:00:00",   
        "aircraft": { AIRCRAFTS },   
        "route": { ROUTES },   
        "flightNumber": "49",   
        "economyPrice": 620.0,   
        "confirmed": true   
    }     
#### Запросы:
>GET /schedules - возвращает массив объектов
>
>GET /schedules/{id} - возвращает один объект по  его id
>
>POST /schedules - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /schedules - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /schedules/{id} - удаляет объект по id, возвращает удалённый объект
>
>POST /schedules/update - меняет или добавляет расписание по шаблонну. при успешном выполнении возвращает изменённый/добавленный объект, при ощибке возвращает null
>
>POST /schedules/search - строит паршруты. На вход получает объект (см. ниже), на выходе массив массивов, где каждый массив второго уровня - маршрут, содержащий от 1 до двух Schedules (см.ещё ниже)
>
>GET /schedules/search - ищет рейсы. на вход получает объект (см. ниже), на выходе массив Schedules по параметрам
> 
        Объект для "POST /schedules/search" и "GET /schedules/search"
        {
            "date":	"2017-10-04",           - дата вылета
            "departureAirport": "DOH",      - аэропорт вылета
            "arrivalAirport": "BAH" -       - aэропорт прибытия
        }

> Вывод "POST /schedules/search":

    [ - общий массив
        [ - маршрут 1
            { - объект Schedules
            }
        ],
        [ - маршрут 2
            { - объект Schedules 1
            },
            { - объект Schedules 2
            }
        ]
        [ - маршрут 3
            { - объект Schedules 1
            },
            { - объект Schedules 2
            }
        ]
    
    ]
### Tickets
#### Объект:
    {     
        "id": 437,     
        "user": { USERS },     
        "schedule": { SCHEDULES },     
        "cabinType": { CABINTYPES },     
        "firstName": "Natividad",     
        "lastName": "Cadigan",     
        "email": null,     
        "phone": "551-342-5205",     
        "passportNumber": "450768649",     
        "country": { COUNTRIES },     
        "bookingReference": "NCADIG",     
        "confirmed": true     
    }     
#### Запросы:
>GET /tickets - возвращает массив объектов
>
>GET /tickets/{id} - возвращает один объект по  его id
>
>POST /tickets - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /tickets - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /tickets/{id} - удаляет объект по id, возвращает удалённый объект

### UsersBlocking
#### Объект:
    {     
        "id": 1,     
        "user": { USERS },     
        "blockingReason": "He is very bad guy"     
    } 
#### Запросы:
>GET /usersblocking - возвращает массив объектов
>
>GET /usersblocking/{id} - возвращает массив объектов по id его user
>
>POST /usersblocking - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /usersblocking - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /usersblocking/{id} - удаляет объект по id, возвращает удалённый объект
### Users
#### Объект:
    {     
        "id": 1,     
        "role": { ROLES },     
        "email": "j.doe@amonic.com",     
        "firstName": "John",     
        "lastName": "Doe",     
        "password": "123",
        "office": { OFFICES },     
        "birthdate": "1983-01-13",     
        "active": true     
    }   
#### Запросы:
>GET /users - возвращает массив объектов
>
>GET /users/{id} - возвращает массив объектов по id его user
>
>GET /users/offices/{id} - возвращает массив объектов по id офиса
>
>POST /users/verify - верификация, потенциальные ответы:
>> ACCESS ACCEPT - доступ разрешён    
>> INCORRECT PASSWORD - неверный пароль    
>>>ЛЮБОЙ ДРУГОЙ ОТВЕТ - причина блокировки    >
> >
>
>POST /users - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /users - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /users/{id} - удаляет объект по id, возвращает удалённый объект

### UsersLogs
#### Объект:
    {
        "id": 1,
        "user": { USERS },
        "logInTime": "2023-10-01T14:35:00",
        "logOutTime": null,
        "crashReason": null,
        "softwareCrash": null,
        "systemCrash": null
    },
#### Запросы:
>GET /userslogs - возвращает массив объектов
>
>GET /userslogs/{id} - возвращает объект(см.ниже) по id его user
>    {
        "usersLogs": [ USERSLOGS ARRAY ],
        "timeSpend": "-0001-12-30T01:22:48.617"
    }
>POST /userslogs - помещает в базу данных переданный объект (переданный объект не должен содержать id), возвращает помещённый объект
>
>PUT /userslogs - редактирует объект, имеющийся в базе данных (выбор редактируемого осуществляется по id)б возвращает изменённый объект или null при ошибке
>
>DELETE /userslogs/{id} - удаляет объект по id, возвращает удалённый объект
