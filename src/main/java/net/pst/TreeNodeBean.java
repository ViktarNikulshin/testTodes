package net.pst;

import net.pst.models.TreeDto;
import net.pst.service.ManagedService;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.RequestScoped;
import java.util.List;


@Component
@RequestScoped
public class TreeNodeBean {
    private TreeNode treeNode;

    private final ManagedService service;


    @Autowired
    public TreeNodeBean(ManagedService service) {
        this.service = service;
    }

    public TreeNode getTreeNode(){
        return service.getTree();
    }
}
