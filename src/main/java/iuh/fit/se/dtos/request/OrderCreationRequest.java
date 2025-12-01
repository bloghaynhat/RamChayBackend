package iuh.fit.se.dtos.request;

import iuh.fit.se.entities.enums.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderCreationRequest {
    Long customerId; // Có thể null cho khách vãng lai
    String receiverName;
    String shippingAddress;
    String receiverPhone; // đổi từ customerPhone thành receiverPhone
    PaymentMethod paymentMethod;
}
