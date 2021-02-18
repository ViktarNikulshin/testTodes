package net.pst.service;

import net.pst.models.ModelDto;
import net.pst.models.TreeDto;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.model.TreeNode;

public interface ManagedService {

    TreeNode getTree();

    Tab getTabView(Integer id);

    ModelDto getRoot();
}
