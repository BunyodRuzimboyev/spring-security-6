package uz.br29.appfl.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarAddReq {

    @NotBlank(message = "Every car must have a name!")
    private String name;

    @NotBlank(message = "Every car must have a model!")
    private String model;

    @Min(value = 1900, message = "The year must be greater than or equal to 1900")
    @Max(value = 2200, message = "The year must be less than or equal to 2200")
    private long year;

}
