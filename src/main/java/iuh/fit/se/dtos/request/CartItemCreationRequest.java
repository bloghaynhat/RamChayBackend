package iuh.fit.se.dtos.request;


import iuh.fit.se.entities.Cart;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemCreationRequest {
    Long productId;
    int quantity;
//    double unitPrice;
//    double subtotal;
//    Long cartId;
}
