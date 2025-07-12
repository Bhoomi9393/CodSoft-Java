# 💱 Currency Converter - Java Console App

A simple and efficient **Java-based currency converter** that uses **real-time exchange rates** from a public API. It allows users to convert between currencies by fetching the latest rates from the internet.

> ✅ CodSoft Java Internship – Task 4  
> 👩‍💻 Developed by: Bhoomika Chaudhary  
> 🗓️ July 2025

---

## 🚀 Features

- Convert from one currency to another using real-time exchange rates
- Supports all major global currencies (USD, EUR, INR, JPY, etc.)
- Input validation for incorrect amount or currency format
- Checks internet availability before API call
- Graceful handling of errors and invalid responses
- Loop for multiple conversions in one session

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- `HttpURLConnection` for API request
- `BufferedReader` for reading API response
- `InetAddress` for internet check
- Java Exception handling for robust input/output processing

---

## 🧠 How It Works

1. Takes base and target currencies from the user.
2. Accepts the amount to be converted.
3. Checks if internet is available.
4. Fetches exchange rate using public API.
5. Calculates the converted amount.
6. Displays the result.
7. Repeats until user exits.
