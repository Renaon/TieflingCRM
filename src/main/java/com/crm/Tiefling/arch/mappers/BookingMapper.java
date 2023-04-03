package com.crm.Tiefling.arch.mappers;

import com.crm.Tiefling.DTO.BookingDTO;
import com.crm.Tiefling.entity.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {

    public List<BookingDTO> returnDTOList(List<Booking> bookings){
        List<BookingDTO> dtos = new ArrayList<>();
        for (Booking booking: bookings) {
            dtos.add(new BookingDTO(booking.getDate(), booking.getUser(), booking.getRoom()));
        }
        return dtos;
    }

    public BookingDTO returnDTO(Booking booking){
        return new BookingDTO(booking.getDate(), booking.getUser(), booking.getRoom());
    }
}
