package com.example.jparelationi1ex.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty
    @Size(min = 4, max = 15)
    private String area;
    @NotEmpty
    @Size(min = 4, max = 15)
    private String street;
    @NotNull
    private int buildingNumber;
}
