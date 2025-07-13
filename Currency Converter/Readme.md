# 💱 Currency Converter – Java Console Application

This is a **Java-based currency converter** that fetches **real-time exchange rates** from a public API and allows users to convert between global currencies.

Developed as **Task 4** during my **Java Development Internship at CodSoft**.

---

## ✅ Internship Details

- 👩‍💻 Developed by: **Bhoomika Chaudhary**
- 🏢 Organization: **CodSoft**
- 🗓️ Duration: **July 2025**
- 🧪 Task: **Currency Converter (Task 4)**

---

## 🚀 Features

- Convert between currencies using **live exchange rates**
- Supports most major currencies (e.g., USD, INR, EUR, JPY, etc.)
- **Input validation** for currency codes and amounts
- Checks **internet connectivity** before API calls
- Gracefully handles invalid inputs and errors
- Allows **multiple conversions** in one session via loop

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- `HttpURLConnection` – to make HTTP requests to API
- `BufferedReader` – to read the API response
- `InetAddress` – to check internet availability
- **Exception Handling** – for robust error processing

---

## 🧠 How It Works

1. Takes **base currency**, **target currency**, and **amount** from the user
2. Checks if internet connection is available
3. Fetches real-time exchange rate using a **public currency API**
4. Calculates and displays the converted amount
5. Repeats the process until the user chooses to exit

---

## 📁 How to Run

1. Clone or download this repository
2. Open in any Java IDE or use terminal
3. Compile and run the main file:

```bash
javac CurrCon.java
java CurrCon
