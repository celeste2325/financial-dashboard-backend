package happy.hive.community.financial.service;

import happy.hive.community.financial.exceptions.BalanceMappingException;
import happy.hive.community.financial.exceptions.NoSuchFileException;
import happy.hive.community.financial.model.Balance;

import java.io.IOException;
import java.util.List;

public interface FinancialService {
    List<Balance> findBalances() throws NoSuchFileException, IOException, BalanceMappingException;
}
