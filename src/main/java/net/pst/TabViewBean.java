package net.pst;

import net.pst.service.ManagedService;
import org.primefaces.component.tabview.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@RequestScoped
public class TabViewBean {
    private List<Tab> tabs;

    private final ManagedService service;

    @Autowired
    public TabViewBean(ManagedService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        tabs = new ArrayList<>();
    }

    public void add(Integer id) {
        if (service.getTabView(id) != null) {
            tabs.add(service.getTabView(id));
        }
    }

    public void remove(Tab tab) {
        tabs.remove(tab);
    }

    public List<Tab> getTabs() {
        return tabs;
    }
}
