package com.iitposs.pos.service.impl;

import com.google.common.reflect.TypeToken;
import com.iitposs.pos.dto.pagenated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.exception.NotFoundException;
import com.iitposs.pos.repo.ItemRepo;
import com.iitposs.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String save(ItemSaveRequestDTO requestDTO) {

        /*Item item = new Item(
                requestDTO.getName(),
                requestDTO.getMeasuringType(),
                requestDTO.getSupplierPrice(),
                requestDTO.getDisplayPrice(),
                requestDTO.getSellingPrice(),
                requestDTO.getQtyOnHand(),
                requestDTO.isActiveState()
        );*/

        Item item = modelMapper.map(requestDTO, Item.class);

        if (!itemRepo.existsById(item.getItemID())) {
            itemRepo.save(item);
            return "Saved....!";
        } else {
            return "Item already exist";
        }
    }

    @Override
    public List<ItemResponseDTO> getItemByName(String itemName) {

        List<Item> items = itemRepo.findAllByNameEqualsAndActiveStateEquals(itemName, true);

        if (!items.isEmpty()) {

            List<ItemResponseDTO> itemResponseDTOS = modelMapper.map(
                    items, new TypeToken<List<ItemResponseDTO>>() {
                    }.getType()
            );
            return itemResponseDTOS;
        } else {
            return null;
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemByState(boolean state, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(state, PageRequest.of(page,size));

        if(!items.isEmpty()){
            List<ItemResponseDTO> itemResponseDTOS=
                    modelMapper.map(items.getContent(), new TypeToken<List<ItemResponseDTO>>() {}.getType());
            return new PaginatedResponseItemDTO(
                    itemResponseDTOS,
                    items.getTotalElements()
            );
        }else {
            throw new NotFoundException("No Data Found...!");
        }
    }
}
