package com.crm.Tiefling.utils.factory;

import com.crm.Tiefling.entity.Authority;
import com.crm.Tiefling.entity.Room;

public class ConcreteCreator extends Creator {

    @Override
    public Room createRoom(String roomName) {
        return new Room(roomName);
    }

    @Override
    public Authority createAuthority(String authorityName) {
        Authority authority = new Authority();
        authority.setAuthority(authorityName);
        return authority;
    }
}
