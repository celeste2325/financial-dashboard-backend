package happy.hive.community.financial.service;

import happy.hive.community.financial.exceptions.BalanceMappingException;
import happy.hive.community.financial.exceptions.NoSuchFileException;
import happy.hive.community.financial.model.Balance;
import happy.hive.community.financial.repository.BalanceRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {
    final private BalanceRepository balanceRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public List<Balance> findBalances() throws NoSuchFileException, IOException, BalanceMappingException {
        return this.balanceRepository.findBalances();
    }
}
