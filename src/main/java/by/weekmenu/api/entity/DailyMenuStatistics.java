package by.weekmenu.api.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class DailyMenuStatistics implements Serializable {

    private static final long serialVersionUID = 3756286465717228068L;

    @Embeddable
    public static class Id implements Serializable {

        private static final long serialVersionUID = 5029998730923370407L;

        @Column(name = "DAY_OF_WEEK_ID")
        private Byte dayOfWeekId;

        @Column(name = "MENU_ID")
        private Long menuId;

        Id() {

        }

        public Id(Byte dayOfWeekId, Long menuId) {
            this.dayOfWeekId = dayOfWeekId;
            this.menuId = menuId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(dayOfWeekId, id.dayOfWeekId) &&
                    Objects.equals(menuId, id.menuId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dayOfWeekId, menuId);
        }

        public Byte getDayOfWeekId() {
            return dayOfWeekId;
        }

        public Long getMenuId() {
            return menuId;
        }
    }

    @EmbeddedId
    private Id id = new Id();

    @Column(name = "PRICE")
    @Digits(
            integer = 3,
            fraction = 2,
            message = "DailyMenuStatistics' price '${validatedValue}' must have up to '{integer}' integer digits and '{fraction}' fraction digits."
    )
    @Positive(message = "DailyMenuStatistics' price '${validatedValue}' must be positive.")
    private BigDecimal price;

    @Column(name = "CALORIES")
    @Positive(message = "DailyMenuStatistics' calories '${validatedValue}' must be positive.")
    private Integer calories;

    @Column(name = "PROTEINS")
    @Positive(message = "DailyMenuStatistics' proteins '${validatedValue}' must be positive.")
    private Integer proteins;

    @Column(name = "FATS")
    @Positive(message = "DailyMenuStatistics' fats '${validatedValue}' must be positive.")
    private Integer fats;

    @Column(name = "CARBS")
    @Positive(message = "DailyMenuStatistics' carbs '${validatedValue}' must be positive.")
    private Integer carbs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "DAY_OF_WEEK_ID",
            updatable = false,
            insertable = false
    )
    @NotNull(message = "DailyMenuStatistics must have have dayOfWeek.")
    private DayOfWeek dayOfWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "MENU_ID",
            updatable = false,
            insertable = false
    )
    @NotNull(message = "DailyMenuStatistics must have have menu.")
    private Menu menu;
}