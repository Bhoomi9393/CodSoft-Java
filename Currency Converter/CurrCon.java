import java.util.Scanner;
import java.net.URL;
import java.net.URI;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.InetAddress;

public class CurrCon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("... Welcome to Currency Converter ...");

        do {
            System.out.print("Enter the base currency (e.g., USD): ");
            String base = sc.nextLine().toUpperCase();

            System.out.print("Enter the target currency (e.g., INR): ");
            String target = sc.nextLine().toUpperCase();

            System.out.print("Enter the amount to convert: ");
            double amount;
            try {
                amount = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a numeric value.");
                continue;
            }

            if (!isInternetAvailable()) {
                System.out.println("No internet connection. Please check your network and try again.");
                continue;
            }

            try {
                String urlString = "https://open.er-api.com/v6/latest/" + base;
                URL url = URI.create(urlString).toURL();

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String json = response.toString();
                String searchKey = "\"" + target + "\":";
                int index = json.indexOf(searchKey);

                if (index != -1) {
                    int start = index + searchKey.length();
                    int end = json.indexOf(",", start);
                    if (end == -1) end = json.indexOf("}", start);

                    String rateStr = json.substring(start, end).trim();
                    double rate = Double.parseDouble(rateStr);
                    double convertedAmount = amount * rate;

                    System.out.printf("%.2f %s = %.2f %s%n", amount, base, convertedAmount, target);
                } else {
                    System.out.println("Could not find exchange rate for " + target);
                }

            } catch (Exception e) {
                System.out.println("Error fetching conversion rate: " + e.getMessage());
            }

            System.out.print("\n Do you want to convert another amount? (yes/no): ");
        } while (sc.nextLine().equalsIgnoreCase("yes"));

        System.out.println("\n Thank you for using Currency Converter!");
        sc.close();
    }

    private static boolean isInternetAvailable() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            return address.isReachable(2000);
        } catch (Exception e) {
            return false;
        }
    }
}
