package umc.mission.week7.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.mission.week7.apiPayLoad.code.DTO.store.StoreRequestDTO;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.apiPayLoad.exception.handler.StoreHandler;
import umc.mission.week7.converter.StoreConverter;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.repository.StoreRepository;
@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    @Override
    public Store createStore(StoreRequestDTO.toCreateStore request) {

        Store newStore = StoreConverter.toStore(request);
        if (request.getName().equals("")) {
            throw new StoreHandler(ErrorStatus.STORE_NAME_EMPTY);
        }
        if (request.getAddress().equals("")) {
            throw new StoreHandler(ErrorStatus.STORE_ADDRESS_EMPTY);
        }
        return storeRepository.save(newStore);
    }

    @Override
    public Store findStoreById(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + storeId));

    }
}
