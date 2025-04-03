SSA-WEB-API is a Dummy RESTful service that determines the state name based on a given Social Security Number (SSN).
The service follows a simple logic where the last digit of the SSN is mapped to a state name.

Features

✅ Fetches state name based on SSN

✅ Basic validation (SSN must be exactly 9 digits)

✅ Logging for requests and responses

✅ Error handling for invalid SSNs

Tech Stack

Backend: Java 17, Spring Boot 3.x

Logging: SLF4J with Logback

Build Tool: Maven
API Endpoints

Method

Endpoint

Description

GET

/ssa-web-api/find/{ssn}

Returns the state name based on SSN
