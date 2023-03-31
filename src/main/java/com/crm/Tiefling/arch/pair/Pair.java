package com.crm.Tiefling.arch.pair;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
public class Pair<L,R> {
     L left;
     R right;
}
