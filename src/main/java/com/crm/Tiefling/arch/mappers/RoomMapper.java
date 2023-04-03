package com.crm.Tiefling.arch.mappers;

import com.crm.Tiefling.DTO.RoomDTO;
import com.crm.Tiefling.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomMapper {

    public List<RoomDTO> returnDTOList(List<Room> rooms){
        List<RoomDTO> dtos = new ArrayList<>();
        for (Room room: rooms) {
            dtos.add(new RoomDTO(room.getId(), room.getName()));
        }
        return dtos;
    }

    public RoomDTO returnDTO(Room room){
        return new RoomDTO(room.getId(), room.getName());
    }
}
