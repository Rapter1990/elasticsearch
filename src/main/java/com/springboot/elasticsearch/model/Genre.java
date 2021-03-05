package com.springboot.elasticsearch.model;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Genre implements Serializable{

    @NonNull
    private String name;
}
