package samuelesimeone.eserciziod2.entities;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Menu {
    private List<Pizze> pizzes;
    private List<Aggiunte> aggiuntes;
    private List<Bevande> bevandes;

    public Menu(List<Pizze> pizzes, List<Aggiunte> aggiuntes, List<Bevande> bevandes) {
        this.pizzes = pizzes;
        this.aggiuntes = aggiuntes;
        this.bevandes = bevandes;
    }

    public void print(){
        pizzes.forEach(System.out::println);
        aggiuntes.forEach(System.out::println);
        bevandes.forEach(System.out::println);
    }
}
