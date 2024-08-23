# Supplier API

Supplier API is a Spring Boot application that provides endpoints to query supplier information based on various criteria.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)

## Features

- Query suppliers based on location, nature of business, and manufacturing process
- Paginated results
- Error handling for various scenarios

## Prerequisites

- Java 11 or higher
- Maven
- Spring Boot 2.x or higher

## Installation

###### 1.Clone the repository:


```
git clone https://github.com/Alphabtw00/Supplier-Api
```

###### 2.Navigate to the project directory:

```
cd supplier-api
```

###### 3.Build the project:

```
mvn clean install
```

###### 4.Run the application:

```
java -jar target/supplier-api-0.0.1-SNAPSHOT.jar
```

## Usage

The API can be accessed at `http://localhost:8080` (assuming default Spring Boot settings).

## API Endpoints

### 1.Query Suppliers

```
POST /api/supplier/query
```
Query suppliers based on specified criteria.

###### Query Parameters:

| Parameter | Type | Description |
|:---------:|:----:|-------------|
| `location` | String | :round_pushpin: The location of the supplier |
| `manufacturingProcess` | ManufacturingProcess | :factory: The manufacturing process (enum) |
| `natureOfBusiness` | NatureOfBusiness | :briefcase: The nature of business (enum) |
| `page` | int | :page_with_curl: The page number (default: 0) |
| `size` | int | :straight_ruler: The page size (default: 10) |

> **Note:** All parameters are required except `page` and `size`, which have default values.

<details>
  <summary>Click here for enum values</summary>

### ManufacturingProcess
- ASSEMBLY
- FABRICATION
- PROCESSING
- (add other values as applicable)

### NatureOfBusiness
- MANUFACTURER
- DISTRIBUTOR
- RETAILER
- (add other values as applicable)
</details>

---

###### Response:

Returns a paginated list of suppliers matching the criteria.

###### Example:

```
POST /api/supplier/query?location=New York&manufacturingProcess=ASSEMBLY&natureOfBusiness=MANUFACTURER&page=0&size=10
```

## Error Handling

The API includes a global exception handler (`SupplierControllerAdvice`) that manages various error scenarios:

- For generic exceptions, it returns a 500 Internal Server Error with a generic message.
- For `RuntimeException`, it returns a 204 No Content status with the exception message.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

######
