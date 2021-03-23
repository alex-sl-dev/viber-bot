package engineer.untitled.realm2bot.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import engineer.untitled.realm2bot.entities.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Value("${untitled.viber.host}")
    private String host;

    @Value("${untitled.viber.token}")
    private String token;

    @Override
    public Account getAccountInfo()
            throws IOException, InterruptedException {
        /*
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .header("X-Viber-Auth-Token", token)
                .uri(URI.create(host + "/pa/get_account_info"))
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .build();

        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        ObjectMapper objectMapper = new ObjectMapper();
         */
        URL url = new URL(host + "/pa/get_account_info");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty ("X-Viber-Auth-Token", token);
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        /* try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        String jsonInputString = "{"name": "Upendra", "job": "Programmer"}";

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        } */
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine = null;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        System.out.println(response.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        Account account = objectMapper.readValue(response.toString(), Account.class);
        System.out.println(account);

        return account;
    }
}
