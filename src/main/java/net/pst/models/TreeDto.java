package net.pst.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.primefaces.model.TreeNode;

@Data
@AllArgsConstructor
public class TreeDto {
    private TreeNode root;
}
