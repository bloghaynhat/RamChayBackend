package iuh.fit.se.mappers;

import iuh.fit.se.dtos.response.ProductCreationResponse;
import iuh.fit.se.entities.Product;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ProductMapper {
    ProductCreationResponse toProductCreationResponse(Product product);
}
