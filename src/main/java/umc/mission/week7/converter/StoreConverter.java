package umc.mission.week7.converter;

import umc.mission.week7.apiPayLoad.code.DTO.store.StoreRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.store.StoreResponseDTO;
import umc.mission.week7.domain.entity.Store;

public class StoreConverter {
    public static StoreResponseDTO.CreateResultDTO toCreateStoreResultDTO(Store store){
        return StoreResponseDTO.CreateResultDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .createdAt(store.getCreatedAt())
                .updateAt(store.getUpdatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.toCreateStore request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }
}
