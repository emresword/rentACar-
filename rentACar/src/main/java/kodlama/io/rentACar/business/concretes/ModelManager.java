package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
	private ModelMapperService modelMapperService;
	private ModelRepository modelRepository;
	private ModelBusinessRules modelBusinessRules;

	@Override
	public List<GetAllModelResponse> getAll() {
		List<Model> models = modelRepository.findAll();

		List<GetAllModelResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelResponse.class))
				.collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		Model model = this.modelRepository.findById(id).orElseThrow();
		GetByIdModelResponse getByIdModelResponse = this.modelMapperService.forResponse().map(model,
				GetByIdModelResponse.class);
		return getByIdModelResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);

	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);

	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);

	}

}
