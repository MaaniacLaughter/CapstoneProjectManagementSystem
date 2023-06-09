package com.example.studentView;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student1 {


    @EqualsAndHashCode.Include
    @Id
    private String name;
    private String srn;
    private String team_id;
    private String email;

}
