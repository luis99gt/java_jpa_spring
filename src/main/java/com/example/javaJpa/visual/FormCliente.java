package com.example.javaJpa.visual;

import com.example.javaJpa.clases.Cliente;
import com.example.javaJpa.clases.ClienteRepository;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

/**
 * Created by L99 on 7/21/2017.
 */
public class FormCliente extends FormLayout {
    private TextField nombre = new TextField("Nombre:");
    private TextField telefono = new TextField("Telefono:");
    private DateField edad = new DateField("Fecha de Nacimiento:");
    private TextField direccion = new TextField("Direccion");
    Button btnSaveCliente = new Button("Guardar Cliente");
    Button btnDeleteCliente = new Button("Eliminar Cliente");
    GridLayout tabCliente = new GridLayout(2,2);
    Grid<Cliente> gridCli = new Grid<>("Clientes");

    private App myApp;



    public FormCliente(App myApp){
        this.myApp = myApp;

        //Iconos
        nombre.setIcon(VaadinIcons.USER);
        telefono.setIcon(VaadinIcons.PHONE);
        edad.setIcon(VaadinIcons.DATE_INPUT);
        direccion.setIcon(VaadinIcons.HOME);
        VerticalLayout formCli = new VerticalLayout();
        formCli.addComponents(nombre,telefono,edad,direccion,btnSaveCliente,btnDeleteCliente);
        btnSaveCliente.setStyleName(ValoTheme.BUTTON_PRIMARY);
        btnSaveCliente.setIcon(VaadinIcons.PLUS_CIRCLE_O);
        btnDeleteCliente.setStyleName(ValoTheme.BUTTON_DANGER);
        btnDeleteCliente.setIcon(VaadinIcons.TRASH);


        btnSaveCliente.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                saveCliente();
            }
        });

        btnDeleteCliente.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                deleteClinete();
            }
        });

        tabCliente.addComponent(formCli,0,0);
        edad.setDateFormat("yyyy-MM-dd");

        //Grid
        //grid desarrolladores
        gridCli.addColumn(Cliente::getId).setCaption("Id");
        gridCli.addColumn(Cliente::getNombre).setCaption("Nombre");
        gridCli.addColumn(Cliente::getTelefono).setCaption("Telefono");
        gridCli.addColumn(Cliente::getEdad).setCaption("Edad");
        gridCli.addColumn(Cliente::getDereccion).setCaption("Direccion");
        gridCli.setWidth("700px");
        tabCliente.addComponent(gridCli,1,0);

        addComponent(tabCliente);
    }

    public void saveCliente() {
        Cliente e = new Cliente();
        e.setNombre(nombre.getValue());
        e.setTelefono(telefono.getValue());
        e.setEdad(String.valueOf(edad.getValue()));
        e.setDereccion(direccion.getValue());
        myApp.clienteRepository.save(e);
        gridCli.setItems(myApp.clienteRepository.findAll());
        nombre.clear();
        edad.clear();
        telefono.clear();
        direccion.clear();
        Notification notif = new Notification(
                "Cliente",
                "Ingresado Correctamente!",
                Notification.Type.HUMANIZED_MESSAGE);
        notif.setDelayMsec(10000);
        notif.show(Page.getCurrent());
    }

    public  void deleteClinete(){
        Cliente e = new Cliente();
        myApp.clienteRepository.delete(gridCli.getSelectedItems());
        gridCli.setItems(myApp.clienteRepository.findAll());
        Notification notif = new Notification(
                "Cliente",
                "Eliminado Correctamente!",
                Notification.Type.WARNING_MESSAGE);
        notif.setDelayMsec(10000);
        notif.show(Page.getCurrent());

    }


}
