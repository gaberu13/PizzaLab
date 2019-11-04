package mk.finki.ukim.mk.lab.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String pizaaType;
    private String clientName;
    private String clientAddress;
    private Long orderId;

}

