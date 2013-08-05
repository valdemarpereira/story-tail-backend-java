package com.valdemar.storytail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class NewTale extends Tale{

    private String tail;
}
