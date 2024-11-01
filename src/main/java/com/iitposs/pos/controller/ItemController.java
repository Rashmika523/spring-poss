package com.iitposs.pos.controller;

import com.iitposs.pos.dto.pagenated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import com.iitposs.pos.service.ItemService;
import com.iitposs.pos.util.enums.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item-save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO requestDTO){

        String message = itemService.save(requestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItembyName(@RequestParam(value = "name") String name){
        List<ItemResponseDTO> responseDTOS = itemService.getItemByName(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",responseDTOS),HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-all-items-by-state",
            params = {"state","page","size"}
    )
    public ResponseEntity<StandardResponse> getAllItemByState(
            @RequestParam(value = "state") boolean state,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){

        PaginatedResponseItemDTO pdto = itemService.getItemByState(state,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",pdto),HttpStatus.CREATED
        );
    }

}
