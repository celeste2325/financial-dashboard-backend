package happy.hive.community.financial.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Balance {
    private String accountName;
    private String accountID;
    private double balance;
    private String currency;
    private String type;
}

