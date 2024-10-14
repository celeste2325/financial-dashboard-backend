package happy.hive.community.financial.repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import happy.hive.community.financial.exceptions.BalanceMappingException;
import happy.hive.community.financial.exceptions.NoSuchFileException;
import happy.hive.community.financial.model.Balance;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Repository
public class BalanceRepositoryImpl implements BalanceRepository {
    private final Gson gson = new Gson();

    public String redFile() throws NoSuchFileException, IOException {
        final String FILE_PATH = "src/main/java/happy/hive/community/financial/balances.json";
        try {
            return Files.readString(Path.of(FILE_PATH));
        } catch (java.nio.file.NoSuchFileException e) {
            throw new NoSuchFileException("The specified file could not be found. Please verify the file path and try again.");
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public List<Balance> findBalances() throws NoSuchFileException, IOException, BalanceMappingException {
        String balancesJson = this.redFile();
        JsonObject jsonObject = JsonParser.parseString(balancesJson).getAsJsonObject();
        Balance[] balance = this.gson.fromJson(jsonObject.getAsJsonArray("accounts"), Balance[].class);
        if (balance == null) {
            throw new BalanceMappingException("Failed to map JSON to Balance object");
        }
        return Arrays.asList(balance);
    }
}
