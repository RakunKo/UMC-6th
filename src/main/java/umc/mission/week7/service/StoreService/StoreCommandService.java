package umc.mission.week7.service.StoreService;

import umc.mission.week7.apiPayLoad.code.DTO.store.StoreRequestDTO;
import umc.mission.week7.domain.entity.Store;

public interface StoreCommandService {
    public Store createStore(StoreRequestDTO.toCreateStore request);

    public Store findStoreById(Long storeId);
}
