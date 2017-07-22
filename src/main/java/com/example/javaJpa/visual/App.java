package com.example.javaJpa.visual;

import com.example.javaJpa.clases.Cliente;
import com.example.javaJpa.clases.ClienteRepository;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by L99 on 7/20/2017.
 */
@SpringUI
public class App extends UI {
    @Autowired
    ClienteRepository clienteRepository;
    private FormCliente formC = new FormCliente(this);

    @Override
    protected void init(VaadinRequest vaadinRequest){
        HorizontalLayout hlayout = new HorizontalLayout();
        hlayout.setSizeFull();

        TabSheet tabsheet = new TabSheet();
        tabsheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabsheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        hlayout.addComponent(tabsheet);
        //Create the first tab GridLayout
        GridLayout tab1 = new GridLayout(2,2);
//        tabsheet.addTab(tab1, "Cliente").setIcon(VaadinIcons.LIST);
        //Form Cliente
        tabsheet.addTab(formC,"Clinetes").setIcon(VaadinIcons.GROUP);




        tab1.setMargin(true);
        tab1.setSpacing(true);
        tab1.setSizeFull();


        setContent(hlayout);

    }
}
