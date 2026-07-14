package com.example.review_service.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ReviewRequest {

    @NotNull(message = "required")
    private Long bookId;

    @NotBlank(message = "required")
    private String userName;

    @NotNull(message = "required")
    @Min(value = 1, message = "min 1")
    @Max(value = 5, message = "max is 5")
    private Integer rating;

    @Size(max = 500, message = "max 500 chars")
    private String comment;

}
