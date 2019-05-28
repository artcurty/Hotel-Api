package reservas.hotel;

import javax.persistence.*;


@Entity
public class Cliente {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    private String nome;
    private int idade;
    private String sexo;

    @ManyToOne
    private Quarto quarto;

    public Cliente(){}

    public Cliente(String nome, String sexo, int idade, Quarto quarto) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.quarto = quarto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
