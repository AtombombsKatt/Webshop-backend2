# Enkel Webshop Backend

## Beskrivning  
Det här är backend för en enkel webshop byggd med Java och Spring Boot. API:et hanterar produkter och ordrar, och lagrar data i minnet med Java Collections.

## Funktioner  
- Hämta alla produkter  
- Hämta en specifik produkt  
- Skapa en order med validering  
- Hämta order efter ID  
- Grundläggande felhantering  
- Enhetstester för produkter och orderservice

## Teknologier  
- Java 17  
- Spring Boot  
- Maven  
- JUnit (testning)  

## API Endpoints  

### Produkter  
- `GET /api/products` — lista alla produkter  
- `GET /api/products/{id}` — hämta produkt via ID  

### Ordrar  
- `POST /api/orders` — skapa en order  
- `GET /api/orders/{id}` — hämta order via ID  

## Validering och felhantering  
- Order måste innehålla minst en vara  
- Kontroll av lagersaldo innan order accepteras  
- Hantering av valideringsfel via ExceptionHandlers  

## Installation och körning  
1. Klona repot  
2. Kör `mvn clean install` för att bygga projektet  
3. Starta med `mvn spring-boot:run`  
4. Använd Postman eller liknande för att testa API:et  

## Testning  
- Enhetstester finns för produkt- och orderservice i `src/test/java`
