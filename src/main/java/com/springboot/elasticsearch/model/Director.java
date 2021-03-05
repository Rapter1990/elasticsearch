package com.springboot.elasticsearch.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Director implements Serializable {

    @NonNull
    private String name;

    private List<Movie> movies;
}
