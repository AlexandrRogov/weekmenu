package by.weekmenu.api.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@Entity
@Table(name = "MENU_RECIPE")
public class MenuRecipe implements Serializable {

    private static final long serialVersionUID = -785102211168469155L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    @Valid
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "RECIPE_ID")
    @Valid
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "DISH_TYPE_ID")
    @Valid
    private DishType dishType;

    @ManyToOne
    @JoinColumn(name = "DAY_OF_WEEK_ID")
    @Valid
    private DayOfWeek dayOfWeek;
}
