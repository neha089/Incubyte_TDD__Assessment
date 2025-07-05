# String Calculator TDD Assessment - IncuByte

## Overview
The **String Calculator** is a Java- based using Test-Driven Development (TDD). It takes a string of numbers separated by delimiters (e.g., commas, newlines, or custom delimiters) and returns their sum. The project follows strict TDD practices, reliable code through iterative test-first development.

### Features
- Returns 0 for empty strings.
- Processes single numbers.
- Sums multiple numbers separated by commas or newlines.
- Supports custom delimiters (e.g., `//;\n1;2;3` or `//[***]\n1***2***3`).
- Handles multiple custom delimiters (e.g., `//[*][%]\n1*2%3`).
- Ignores numbers greater than 1000.
- Throws exceptions for negative numbers with a clear message.
- Handles invalid delimiter formats with exceptions.

## Test-Driven Development (TDD)
### What is TDD?
Test-Driven Development (TDD) is a software development approach where tests are written before the code. Each test defines a specific requirement, and code is written to pass the test, ensuring functionality and reliability.

### Why Use TDD?
- **Reliability**: Tests ensure code meets requirements and prevents regressions.
- **Clarity**: Writing tests first clarifies the expected behavior.
- **Maintainability**: Modular, well-tested code is easier to refactor and extend.
- **Confidence**: Comprehensive tests provide assurance that the code works as intended.

### TDD Process
1. Write a failing test (Red).
2. Write minimal code to pass the test (Green).
3. Refactor to improve code quality while keeping tests passing.

## Example Test Cases
The following examples show how the String Calculator processes various inputs:

- **Input**: `""` → **Output**: `0`
- **Input**: `"1"` → **Output**: `1`
- **Input**: `"30"` → **Output**: `30`
- **Input**: `"1,2"` → **Output**: `3`
- **Input**: `"10\n2,8"` → **Output**: `20`
- **Input**: `"//;\n1;2;3;4"` → **Output**: `10`
- **Input**: `"3,4,-8"` → **Output**: Throws `IllegalArgumentException: Negative numbers not allowed: -8`
- **Input**: `"10,2000,1001,11"` → **Output**: `21`
- **Input**: `"//[***]\n10***1***8"` → **Output**: `19`
- **Input**: `"//[*][%]\n1*2%3"` → **Output**: `6`

### How Tests Are Handled
The `StringCalculator` class processes inputs as follows:
- **Empty String**: Returns 0 for empty input.
- **Single Number**: Converts the string to an integer.
- **Comma/Newline Delimiters**: Splits input on commas or newlines.
- **Custom Delimiters**: Extracts delimiters from `//[delimiter]\n`, supporting single or multiple delimiters.
- **Negative Numbers**: Throws an exception listing all negative numbers.
- **Numbers > 1000**: Ignores numbers greater than 1000 during summation.

The code is modular, with `extractDelimiter`, `splitNumbers`, and `parseAndSum` handling specific tasks, ensuring clarity and maintainability.

## Code Coverage
The project achieves **100% coverage**

![100% Coverage Report](screenshots/c.png)


### Test Cases 
| Description | Screenshots |
|-------------|-------------|
| [Added StringCalculator class and init JUnit scaffold] | ![Init Code](screenshots/init_code.png#width=600px) |
| [Step-1] Add and Pass test: empty string returns 0 | ![Step-1 Pass](screenshots/1p.png#width=600px) |
| [Step-2] Add failing test: single number string should return the number | ![Step-2 Fail](screenshots/2f.png#width=600px) |
| [Step-2] Pass test: single number returns its value from string to integer | ![Step-2 Pass](screenshots/2p.png#width=600px) |
| [Step-3] Add failing test: comma separated two string should return the sum of that number | ![Step-3 Fail](screenshots/3f.png#width=600px) |
| [Step-3] Pass test: comma separated two string should return the sum of that number | ![Step-3 Pass](screenshots/3p.png#width=600px) |
| [Step-4] Add failing test: comma separated multiple number of string should return the sum of that number | ![Step-4 Fail](screenshots/4f.png#width=600px) |
| [Step-4] Pass test: comma separated multiple number of string should return the sum of that number | ![Step-4 Pass](screenshots/4p.png#width=600px) |
| [Step-5] Add passing test cases: multiple comma-separated numbers return correct sum | ![Step-5 Pass](screenshots/5p.png#width=600px) |
| [Step-6] Add failing test: multiple comma-separated numbers with newline delimiter should return correct sum | ![Step-6 Fail](screenshots/6f.png#width=600px) |
| [Step-6] Pass test: multiple comma-separated numbers with newline delimiter should return correct sum | ![Step-6 Pass](screenshots/6p.png#width=600px) |
| [Step-7] Add failing test: multiple comma-separated numbers with any delimiter should return correct sum | ![Step-7 Fail](screenshots/7f.png#width=600px) |
| [Step-7] Pass test: multiple comma-separated numbers with any delimiter should return correct sum | ![Step-7 Pass](screenshots/7p.png#width=600px) |
| [Step-8] Add failing test: if in input there is a negative number in string need to throw exception | ![Step-8 Fail](screenshots/8f.png#width=600px) |
| [Step-8] Pass test: if in input there is a negative number in string need to throw exception | ![Step-8 Pass](screenshots/8p.png#width=600px) |
| Change in exception's message based on documentation | ![Exception Message](screenshots/exc.png#width=600px) |
| [Step-9] Add failing test: if in input there is a >1000 number is there then ignore it and return sum | ![Step-9 Fail](screenshots/9f.png#width=600px) |
| [Step-9] Pass test: if in input there is a >1000 number is there then ignore it and return sum | ![Step-9 Pass](screenshots/9p.png#width=600px) |
| [Step-10] Add failing test: any length delimiter in [] | ![Step-10 Fail](screenshots/10f.png#width=600px) |
| [Step-10] Pass test: any length delimiter in [] | ![Step-10 Pass](screenshots/10p.png#width=600px) |
| [Step-11] Pass test: any length of any number of delimiters in [] | ![Step-11 Pass](screenshots/11p.png#width=600px) |
| [Step-12] Pass test: handle all branch and lines | ![Step-12 Pass](screenshots/14p.png#width=600px) |


