package com.iitposs.pos.service;

import com.iitposs.pos.dto.pagenated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {

    String save(ItemSaveRequestDTO requestDTO);

    List<ItemResponseDTO> getItemByName(String itemName);

    PaginatedResponseItemDTO getItemByState(boolean state, int page, int size);
}
