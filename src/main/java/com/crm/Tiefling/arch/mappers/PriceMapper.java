package com.crm.Tiefling.arch.mappers;

import com.crm.Tiefling.DTO.PriceDTO;
import com.crm.Tiefling.DTO.RoomDTO;
import com.crm.Tiefling.entity.Price;
import com.crm.Tiefling.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class PriceMapper {

    public List<PriceDTO> returnDTOList(List<Price> prices){
        List<PriceDTO> dtos = new ArrayList<>();
        for (Price price: prices) {
            dtos.add(new PriceDTO(price.getId(), price.getTime(), price.getPrice()));
        }
        return dtos;
    }

    public PriceDTO returnDTO(Price price){
        return new PriceDTO(price.getId(), price.getTime(), price.getPrice());
    }
}
