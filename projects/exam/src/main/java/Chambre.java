
public class Chambre {
    private int id;
    private String nom;
    private String etat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Chambre(int id, String nom, String etat) {
        this.id = id;
        this.nom = nom;
        this.etat = etat;
    }
}
