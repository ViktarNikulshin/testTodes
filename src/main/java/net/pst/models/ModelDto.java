package net.pst.models;

import lombok.Data;

@Data
public class ModelDto {
    private Integer id;
    private String name;
    private String content;
    private Boolean folder;
    private Integer parent;
}
