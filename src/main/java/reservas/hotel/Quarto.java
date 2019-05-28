package reservas.hotel;


import javax.persistence.*;


@Entity
public class Quarto {
    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    private boolean ocupado;
    private float preco;
    private int numLeito;
    private int numQuarto;

    public Quarto() {}

    public Quarto(boolean ocupado, float preco, int numLeito,int numQuarto){
        this.ocupado = ocupado;
        this.preco = preco;
        this.numLeito = numLeito;
        this.numQuarto = numQuarto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getNumLeito() {
        return numLeito;
    }

    public void setNumLeito(int numLeito) {
        this.numLeito = numLeito;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }
}
