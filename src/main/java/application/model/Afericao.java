package application.model;

import jakarta.persistence.*;

@Entity
public class Afericao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String id_sensor;
    private String unidade;
    private String valor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getId_sensor() { return id_sensor; }
    public void setId_sensor(String id_sensor) { this.id_sensor = id_sensor; }

    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }
}
