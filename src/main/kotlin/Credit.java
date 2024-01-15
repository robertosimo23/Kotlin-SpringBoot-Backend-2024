import jdk.jshell.Snippet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Credit extends Customer {
    private UUID creditCode;
    private BigDecimal creditValue;
    private LocalDate dayFirstInstallment;
    private int numberOffInstallments;
    private interface Status status;

    private Customer customer;
    private Long id;
}
