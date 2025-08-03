# JSON Parser

A lightweight JSON parser implementation in Java that converts JSON strings into Java objects through three main phases: tokenization, parsing, and binding.

## Overview

This project implements a custom JSON parser that demonstrates how to convert JSON data into typed Java objects. Check out the [example implementation](src/main/java/com/parser/json/example/Main.java) to see it in action.


## Features

- Recursive Descent Parsing for clear and maintainable code
- Support for nested objects and arrays
- Type-safe conversion to Java objects
- Handling of primitive types (string, number, boolean, null)
- Clear separation of concerns between parsing phases

## How It Works

The JSON parsing process is divided into three main phases:

### 1. Tokenizer Phase

The tokenizer (lexical analysis) breaks down the input JSON string into a sequence of tokens. It:
- Identifies basic JSON elements like curly braces, square brackets, commas, colons
- Recognizes primitive values (strings, numbers, booleans, null)
- Handles whitespace and formatting
- Produces a stream of tokens for the parser

### 2. Parser Phase

The parser (syntactic analysis) takes the stream of tokens and:
- Constructs a hierarchical representation of the JSON data
- Validates the JSON structure and syntax
- Ensures proper nesting of objects and arrays
- Creates an abstract syntax tree (AST) or similar intermediate representation

### 3. Binder Phase

The binder (semantic analysis) converts the parsed structure into Java objects by:
- Mapping JSON objects to Java classes
- Converting JSON arrays to Java collections
- Handling type conversion for primitive values
- Resolving nested objects and relationships
- Applying any necessary data validation