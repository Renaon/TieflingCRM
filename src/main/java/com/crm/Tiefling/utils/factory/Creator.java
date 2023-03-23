package com.crm.Tiefling.utils.factory;

import com.crm.Tiefling.entity.Authority;
import com.crm.Tiefling.entity.Room;

public abstract class Creator {
    public abstract Room createRoom(String name);

    public abstract Authority createAuthority(String authority);
}
