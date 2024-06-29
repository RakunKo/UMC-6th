package umc.mission.week7.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.mission.week7.apiPayLoad.ApiResponse;
import umc.mission.week7.apiPayLoad.code.DTO.store.StoreRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.store.StoreResponseDTO;
import umc.mission.week7.converter.StoreConverter;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.service.StoreService.StoreCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.toCreateStore request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));

    }
}
