# Warehouse

## Table of contents
* [General info](#general-info)
* [Setup](#setup)
* [Tests](#tests)

## General info
Warehouse management project by GytisDr.

## Setup
Change application settings.
Using Eclipse IDE, use: Run as -> Spring Boot App.

## Tests
For tests to work add @Profile("test") annotation to SecurityConfig.
For testing add @AutoConfigureMockMvc(addFilters = false) annotation to SupplierControllerTests

