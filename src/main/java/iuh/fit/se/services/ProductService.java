package iuh.fit.se.services;

import iuh.fit.se.dtos.request.ProductCreationRequest;
import iuh.fit.se.dtos.response.ProductCreationResponse;

public interface ProductService {
    ProductCreationResponse createProduct(ProductCreationRequest productCreationRequest);
}
