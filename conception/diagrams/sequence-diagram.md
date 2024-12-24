``` mermaid
    sequenceDiagram
  autonumber
    participant User
    participant Frontend
    participant Backend
    participant Database

    User->>+Frontend: Login with Username & Password
    Frontend->>+Backend: Sends credentials
    Backend->>Backend: Validates credentials
    Backend-->>Frontend: Returns JWT
    Frontend-->>User: Stores JWT (e.g., in local storage)

    User->>+Frontend: Makes API request (with JWT)
    Frontend->>+Backend: Sends request with JWT in headers
    Backend->>Backend: Verifies JWT

    alt JWT is not valid
        Backend-->>Frontend: Sends error message
        Frontend-->>User: Displays error
    else JWT is valid
        Backend->>+Database: Interacts with database
        Database-->>Backend: Returns protected data
        Backend-->>Frontend: Sends protected data
        Frontend-->>User: Displays protected content
    end

```

