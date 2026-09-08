# Movie Booking Manager

A simple Java-based movie booking demo that demonstrates seat locking, booking management, and a payment strategy pattern.

## About

Movie Booking Manager is a lightweight demonstration application implemented in Java that showcases a modular approach to handling movie seat reservations. It is intended as an educational example and a starting point for building more complete booking systems. Key goals and focus areas:

- Demonstrate safe concurrent booking behaviour using temporary seat locks to avoid double-booking.
- Show how to separate concerns by using a BookingManager/MovieBookingService core with interchangeable payment strategies (Strategy pattern).
- Provide a small, readable codebase suitable for learning, prototyping, and extension (persistence, REST APIs, UI).

This project is not production-ready — it uses in-memory data structures and simple examples to keep the code easy to understand. You can extend it by adding persistence, authentication, improved error handling, and integration tests.

## Language

- Java (100%)

## Project structure

- BookingManager.java — Coordinates booking flow and user interactions (high-level manager).
- MovieBookingService.java — Core booking service responsible for reserving seats and processing bookings.
- SeatLockManager.java — Handles temporary seat locks to prevent double-booking.
- PaymentStrategy.java — Payment strategy interface.
- CreditCardPaymentStrategy.java — A sample implementation of PaymentStrategy for credit card payments.
- MovieBookingDemo.java — Demo / entry point with a `main` method to run the example.
- entities/ — Domain model classes (Movie, Seat, Booking, etc.).
- enums/ — Enum types used across the project.
- movieBooking.iml, .idea/ — IntelliJ project files (IDE-specific).

## Requirements

- Java 8 or later
- JDK and javac on your PATH

## Build & Run

From the project root you can compile and run the demo using the command line:

1. Compile all Java files:

   javac -d out $(find . -name "*.java")

   or on Windows (PowerShell):

   Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName } | %{ "javac -d out $_" }

2. Run the demo (assuming compiled classes are in `out`):

   java -cp out MovieBookingDemo

Alternatively, open the project in IntelliJ IDEA and run `MovieBookingDemo` from the IDE.

## How it works (overview)

1. MovieBookingDemo starts the demo and invokes the BookingManager/MovieBookingService.
2. MovieBookingService uses SeatLockManager to lock seats while payment is processed.
3. PaymentStrategy allows swapping different payment implementations (e.g., credit card) without changing booking logic.

## Extending

- Add more payment strategies by implementing `PaymentStrategy`.
- Add persistence by replacing in-memory data structures with a database.
- Add a REST API wrapper for web/mobile clients.

## Contributing

Contributions are welcome. Please open an issue or a pull request describing your change.

## License

This repository does not include an explicit license. If you want to allow others to use, modify, and distribute this code, add a LICENSE file (for example, MIT or Apache-2.0).
