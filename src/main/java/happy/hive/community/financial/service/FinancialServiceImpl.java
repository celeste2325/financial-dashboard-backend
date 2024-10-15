package happy.hive.community.financial.service;

import happy.hive.community.financial.exceptions.BalanceMappingException;
import happy.hive.community.financial.exceptions.NoSuchFileException;
import happy.hive.community.financial.model.Balance;
import happy.hive.community.financial.repository.FinancialRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {
    final private FinancialRepository balanceRepository;

    public FinancialServiceImpl(FinancialRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public List<Balance> findBalances() throws NoSuchFileException, IOException, BalanceMappingException {
        return this.balanceRepository.findBalances();
    }
}
