package iuh.fit.se.services;

import iuh.fit.se.dtos.request.CategoryCreationRequest;
import iuh.fit.se.dtos.response.CategoryCreationResponse;

public interface CategoryService {
    CategoryCreationResponse createCategory(CategoryCreationRequest request);
}
