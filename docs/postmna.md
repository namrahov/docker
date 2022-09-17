
#### Account Servisi (Account Yaratma)
```
 http://localhost:8501/account

{
	"username" : "temelt",
    "name" : "Taner",
    "email" : "haydi.kodlayalim@gmail.com"
    
}
```

#### Ticket Servisi (Ticket Yaratma)

```
http://localhost:8502/ticket

{
	"description" : "Test Ticket 1",
    "notes" : "Test Ticket 1 - Docker Compose Hatasi",
    "assignee" : "temelt",
    "priorityType" : "URGENT",
    "ticketStatus" : "OPEN",
    "ticketDate" : "1999-01-01"
}
```