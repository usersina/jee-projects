import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chambre {
    private int id;
    private String nom;
    private String etat;
}
