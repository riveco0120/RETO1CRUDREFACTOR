package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column()
    private String name;

    @Column()
    private boolean completed;

    @Column()
    private Long groupListId;

    //Relacion muchos a uno debido a que varios todo puede estar en una lista
    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = TodoList.class,
            optional = false)
    @JoinColumn(name = "todoId",nullable = false)
    @JsonBackReference
    private TodoList list;

    public Todo(){

    }

    public Todo(String name, boolean completed, Long group_list_id) {
        this.name = name;
        this.completed = completed;
        this.groupListId = group_list_id;
    }
}
