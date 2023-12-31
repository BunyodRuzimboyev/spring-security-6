package uz.br29.appfl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarEditReq {

    private Long id;
    private String name;
    private String model;
    private long year;

}
