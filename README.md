## 1

## 6. Build Management

### Maven:

- mutli-module
- calls tests automatically
-

## 7. Tests

### Unit Tests:

- [ItemListServiceTest](coop-list-backend/src/test/java/de/nick2202/cooplist/backend/service/ItemListServiceTest.java)
- [ListItemServiceTest](coop-list-backend/src/test/java/de/nick2202/cooplist/backend/service/ListItemServiceTest.java)
- [UserServiceTest](coop-list-backend/src/test/java/de/nick2202/cooplist/backend/service/UserServiceTest.java)

### Integration Tests:

- [ListItemRepositoryTest](coop-list-backend/src/test/java/de/nick2202/cooplist/backend/repository/ListItemRepositoryTest.java)
- [Endpoint Tests Overview](resources/Postman Integration Tests Overview.png) (manual via Postman)
- [Endpoint Test RegisterUser (POST)](resources/Postman Integration Tests Overview.png) (manual via Postman)

## 10. DSL

- [example 1](coop-list-backend/src/main/java/de/nick2202/cooplist/backend/converter/UserDtoConverter.java) (Builder
  Pattern)
- [example 2](coop-list-backend/src/main/java/de/nick2202/cooplist/backend/service/ListItemService.java) (RegEx)
- [example 3](coop-list-backend/src/main/java/de/nick2202/cooplist/backend/repository/ListItemRepository.java) (SQL)

## 11. Functional Programming

- [example 1](coop-list-backend/src/main/java/de/nick2202/cooplist/backend/service/ItemListService.java)
- [example 2](coop-list-backend/src/main/java/de/nick2202/cooplist/backend/service/ListItemService.java)

<br>
missing:

- user authentication
- frontend