package samuelesimeone.eserciziod2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import samuelesimeone.eserciziod2.entities.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeansConfig {

    @Bean
    Aggiunte getPomodoro(){
        return new Aggiunte("Sugo", 100,0.50);
    }

    @Bean
    Aggiunte getFormaggio(){
        return new Aggiunte("Formaggio", 200, 0.70);
    }

    @Bean
    Aggiunte getProsciutto(){
        return new Aggiunte("Prosciutto", 150, 1.00);
    }

    @Bean
    Aggiunte getPanna(){
        return new Aggiunte("Panna", 210, 1.20);
    }

    @Bean
    List<Aggiunte> getListaIngredientiMargherita(){
        ArrayList<Aggiunte> ingredienti = new ArrayList<>();
        ingredienti.add(getPomodoro());
        ingredienti.add(getFormaggio());
        return ingredienti;
    }

    @Bean
    List<Aggiunte> getIngredientiProscPanna(){
        ArrayList<Aggiunte> ingredienti = new ArrayList<>();
       ingredienti.addAll(getListaIngredientiMargherita());
        ingredienti.add(getPanna());
        ingredienti.add(getProsciutto());
        return ingredienti;
    }

    @Bean
    Pizze getMargherita(){
    ArrayList<Aggiunte> ingredienti = new ArrayList<>();
    ingredienti.addAll(getListaIngredientiMargherita());
    long cal = 500 + ingredienti.stream().mapToLong(Alimenti::getCal).sum();
    double prezzo = 2.00 + ingredienti.stream().mapToDouble(Alimenti::getPrezzo).sum();
    return new Pizze("Margherita", cal, prezzo, ingredienti);
    }

    @Bean
    Pizze getProsciuttoPanna(){
        ArrayList<Aggiunte> ingredienti = new ArrayList<>();
        ingredienti.addAll(getIngredientiProscPanna());
        long cal = 500 + ingredienti.stream().mapToLong(Alimenti::getCal).sum();
        double prezzo = 2.00 + ingredienti.stream().mapToDouble(Alimenti::getPrezzo).sum();
        return new Pizze("Panna e Prosciutto", cal, prezzo, ingredienti);
    }

    @Bean
    Bevande getCola(){
        return new Bevande("Coca-Cola", 150, 2.00, 0.6);
    }

    @Bean
    Bevande getAcqua(){
        return new Bevande("Acqua", 0, 1.00, 1);
    }

    @Bean(name = "menu")
    Menu getMenu(List<Pizze> Pizze, List<Aggiunte> Aggiunte, List<Bevande> Bevande){
        return new Menu(Pizze, Aggiunte, Bevande);
    }
}
