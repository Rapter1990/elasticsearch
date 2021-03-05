package com.springboot.elasticsearch.model;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Genre implements Serializable {

    @NonNull
    private String name;
}
