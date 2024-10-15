package happy.hive.community.financial.repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import happy.hive.community.financial.exceptions.BalanceMappingException;
import happy.hive.community.financial.exceptions.NoSuchFileException;
import happy.hive.community.financial.model.Balance;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Repository
public class FinancialRepositoryImpl implements FinancialRepository {
    private final Gson gson = new Gson();

    public String readFile() throws IOException, NoSuchFileException {
        Resource resource = new ClassPathResource("balances.json");
        try (InputStream inputStream = resource.getInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (java.nio.file.NoSuchFileException e) {
            throw new NoSuchFileException("The specified file could not be found. Please verify the file path and try again.");
        } catch (IOException e) {
            throw new IOException("An error occurred while reading the file: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Balance> findBalances() throws NoSuchFileException, IOException, BalanceMappingException {
        String balancesJson = this.readFile();
        JsonObject jsonObject = JsonParser.parseString(balancesJson).getAsJsonObject();
        Balance[] balance = this.gson.fromJson(jsonObject.getAsJsonArray("accounts"), Balance[].class);
        if (balance == null) {
            throw new BalanceMappingException("Failed to map JSON to Balance object");
        }
        return Arrays.asList(balance);
    }
}
