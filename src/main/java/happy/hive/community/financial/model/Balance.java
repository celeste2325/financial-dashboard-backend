package happy.hive.community.financial.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Balance {
    private String accountId;
    private String accountName;
    private double balance;
    private String currency;
}

