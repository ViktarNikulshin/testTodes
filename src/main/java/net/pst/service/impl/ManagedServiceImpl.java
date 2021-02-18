package net.pst.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.pst.models.ModelDto;
import net.pst.models.TreeDto;
import net.pst.proxy.ApiProxy;
import net.pst.service.ManagedService;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagedServiceImpl implements ManagedService {

    private final ApiProxy proxy;

    @Autowired
    public ManagedServiceImpl(ApiProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public TreeNode getTree() {
        int i = 1;
        TreeNode tree = new DefaultTreeNode(getRoot(), null);
        TreeNode child = new DefaultTreeNode(getModel(i), tree);
        child.setParent(tree);
        initNode(i, child);
        return tree;
    }

    @Override
    public Tab getTabView(Integer id) {
        Tab tab = new Tab();
        Gson gson = new Gson();
        String json = proxy.getById(id);
        ModelDto modelDto = gson.fromJson(json, ModelDto.class);
        if (modelDto.getFolder()) {
            return null;
        } else {
            tab.setTitle(modelDto.getName());
            tab.setAriaLabel(modelDto.getContent());
            return tab;
        }
    }

    public ModelDto getModel(Integer id) {
        Gson gson = new Gson();
        String json = proxy.getById(id);
        ModelDto modelDto = gson.fromJson(json, ModelDto.class);
        return modelDto;
    }

    @Override
    public ModelDto getRoot() {
        Gson gson = new Gson();
        String json = proxy.getRoot();
        return gson.fromJson(json, ModelDto.class);
    }

    private void initNode(int i, TreeNode parent) {
        List<ModelDto> modelDtos = new ArrayList<>();
        Gson gson = new Gson();
        String json = proxy.getChildren(i);
        modelDtos = gson.fromJson(json, new TypeToken<List<ModelDto>>() {
        }.getType());
        if (modelDtos.size() != 0) {
            for (ModelDto model : modelDtos) {
                TreeNode treeNode = new DefaultTreeNode(model, parent);
                treeNode.setParent(parent);
                initNode(model.getId(), treeNode);
            }
        }
    }
}
