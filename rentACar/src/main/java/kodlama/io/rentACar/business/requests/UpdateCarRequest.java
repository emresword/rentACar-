package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	@NotNull
	@NotBlank
	private int id;
	@NotNull
	@NotBlank
	@Size(min=3,max=20)
	private String name;
	@NotNull
	@NotBlank
	private String plate;
	@NotNull
	@NotBlank
	private int state;
	@NotNull
	@NotBlank
	private int modelYear;
	@NotNull
	@NotBlank
	private double dailyPrice;
	@NotNull
	@NotBlank
	private String modelId;
	@NotNull
	@NotBlank
	private String brandId;
}
