package kodlama.io.rentACar.business.abstracts;

import java.util.List;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {
	List<GetAllModelResponse> getAll();

	GetByIdModelResponse getById(int id);

	void add(CreateModelRequest createModelRequest);

	void delete(int id);

	void update(UpdateModelRequest updateModelRequest);
}
