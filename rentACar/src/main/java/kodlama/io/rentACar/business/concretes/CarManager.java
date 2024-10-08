package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.business.rules.CarBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
	private ModelMapperService modelMapperService;
	private CarRepository carRepository;
	private CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarResponse> getAll() {
		List<Car> cars=this.carRepository.findAll();
		List<GetAllCarResponse> getAllCarResponses=cars.stream()
				.map(car-> this.modelMapperService.forResponse()
				.map(car,GetAllCarResponse.class)).collect(Collectors.toList());
		return getAllCarResponses;
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		Car car=this.carRepository.findById(id).orElseThrow();
		GetByIdCarResponse getByIdCarResponse=this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
		return getByIdCarResponse;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		this.carBusinessRules.checkIfBrandNameExists(createCarRequest.getName());
		Car car=this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);

	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car car=this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);

	}

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);

	}
}
