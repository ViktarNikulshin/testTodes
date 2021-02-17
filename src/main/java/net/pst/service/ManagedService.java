package net.pst.service;

import net.pst.models.ModelDto;
import net.pst.models.TreeDto;
import org.primefaces.model.TreeNode;

public interface ManagedService {

    TreeNode getTree();

    String getContext(Integer id);

    ModelDto getRoot();
}
