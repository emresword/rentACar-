package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {
	private int id;
	private String name;
	private String plate;
	private int state;
	private int modelYear;
	private double dailyPrice;
	private String modelName;
	private String brandName;
}
