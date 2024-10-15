package happy.hive.community.financial.controller;

import happy.hive.community.financial.exceptions.BalanceMappingException;
import happy.hive.community.financial.exceptions.NoSuchFileException;
import happy.hive.community.financial.model.Balance;
import happy.hive.community.financial.service.FinancialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("balance")
@CrossOrigin(origins = "*")
public class FinancialController {
    final private FinancialService balanceService;

    public FinancialController(FinancialService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/balances")
    public ResponseEntity<List<Balance>> getBalances() throws NoSuchFileException, IOException, BalanceMappingException {
        return new ResponseEntity<>(this.balanceService.findBalances(), HttpStatus.OK);
    }
}
