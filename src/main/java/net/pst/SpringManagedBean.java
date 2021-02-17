package net.pst;

import net.pst.models.TreeDto;
import net.pst.service.ManagedService;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.RequestScoped;


@Component
@RequestScoped
public class SpringManagedBean {
    private TreeNode treeNode;
    private String context;

    private final ManagedService service;


    @Autowired
    public SpringManagedBean(ManagedService service) {

        this.service = service;

    }

//    @Autowired
//    public SpringManagedBean(SpringManagedService sms, JsfManagedService jms) {
//        super("Spring", sms, jms);
//    }

    public TreeNode getTreeNode(){
        return service.getTree();
    }

    public String getContext(){
        String str = service.getContext(1);
        this.context = str;
        return service.getContext(1);
    }
}
