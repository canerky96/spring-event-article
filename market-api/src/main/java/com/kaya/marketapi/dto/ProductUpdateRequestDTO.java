package com.kaya.marketapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequestDTO {

  @NotNull(message = "Price can not be null")
  @Min(1)
  private Long price;
}
