//package com.example;
////package com.example.student;
//
//import com.example.project.CapstoneView;
//import com.vaadin.flow.component.applayout.AppLayout;
//import com.vaadin.flow.component.applayout.DrawerToggle;
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.orderedlayout.FlexComponent;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.router.RouterLink;
//import com.example.student.StudentView;
//
//@Route("index")
//// tag::snippet[]
//public class AppLayoutBasic extends AppLayout {
//
//    public AppLayoutBasic() {
//        createHeader();
//        createDrawer();
//    }
//
//    public void createHeader(){
//        H1 logo =new H1("Capstone Projects Management System");
//        logo.addClassNames("text-l","m-m");
//
//        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(),logo);
//
//        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
//        header.expand(logo);
//        header.setWidthFull();
//        header.addClassNames("py-0","py-m");
//
//        addToNavbar(header);
//    }
//
//    public void createDrawer(){
//        RouterLink capstoneView = new RouterLink("Projects", com.example.project.CapstoneView.class);
//        RouterLink studentView = new RouterLink("Students", com.example.student.StudentView.class);
//        RouterLink facultyView = new RouterLink("Faculty", com.example.faculty.FacultyView.class);
//
//        addToDrawer(new VerticalLayout(
//                capstoneView,
//                facultyView,
//                studentView
//        ));
//    }
//
//
//}
//
package com.example;
//package com.example.student;

import com.example.faculty.FacultyView;
import com.example.project.CapstoneView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.example.student.StudentView;
import jakarta.annotation.security.PermitAll;

@Route("index")
@PermitAll
//@CssImport("./styles/styles.css")
public class AppLayoutBasic extends AppLayout {

    public AppLayoutBasic() {
        createHeader();
        createContent();
    }

    public void createHeader() {
        //H1 logo = new H1("Capstone Projects Management System");
        H1 logo = new H1("Coordinator Dashboard");

        logo.addClassNames("text-l", "m-m", "text-center");

        HorizontalLayout header = new HorizontalLayout(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames("py-0", "py-m");

        addToNavbar(header);
    }

    public void createContent() {
        Button projectsButton = new Button("Projects", event -> {
            UI.getCurrent().navigate(CapstoneView.class);
        });
        projectsButton.setHeight("200px");
        projectsButton.setWidth("200px");

        Button studentsButton = new Button("Students", event -> {
            UI.getCurrent().navigate(StudentView.class);
        });
        studentsButton.setHeight("200px");
        studentsButton.setWidth("200px");

        Button facultyButton = new Button("Faculty", event -> {
            UI.getCurrent().navigate(FacultyView.class);
        });
        facultyButton.setHeight("200px");
        facultyButton.setWidth("200px");

        HorizontalLayout content = new HorizontalLayout(
                projectsButton,
                studentsButton,
                facultyButton
        );
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        content.setSpacing(true);

        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setPadding(true);
        wrapper.setSpacing(true);
        wrapper.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        wrapper.add(content);
        wrapper.setSizeFull();

        setContent(wrapper);
    }
}