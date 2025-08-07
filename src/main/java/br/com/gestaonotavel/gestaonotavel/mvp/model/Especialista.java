
package br.com.udemyjava.gestao.notavel.mvp.model;

import jakarta.persistence.*;
import java.util.Objects;

/**
 *
 * @author carol
 */
@Entity
@Table(name = "especialista")
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 100)
    private String especialidade;

    @Column(name = "valor_sessao")
    private Double valorSessao;

    @Column(name = "duracao_sessao_minutos")
    private Integer duracao;

    @Column(name = "max_pacientes")
    private Integer maxPacientes;

    @Column(name = "pacientes_atuais")
    private Integer pacientesAtuais;

    @Column(name = "registro_profissional", nullable = false, unique = true, length = 50)
    private String registroProfissional;

    public Especialista() {
    }

    public Especialista(Integer id, String nome, String especialidade, Double valorSessao, Integer duracao, Integer maxPacientes, Integer pacientesAtuais, String registroProfissional) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.valorSessao = valorSessao;
        this.duracao = duracao;
        this.maxPacientes = maxPacientes;
        this.pacientesAtuais = pacientesAtuais;
        this.registroProfissional = registroProfissional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Double getValorSessao() {
        return valorSessao;
    }

    public void setValorSessao(Double valorSessao) {
        this.valorSessao = valorSessao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getMaxPacientes() {
        return maxPacientes;
    }

    public void setMaxPacientes(Integer maxPacientes) {
        this.maxPacientes = maxPacientes;
    }

    public Integer getPacientesAtuais() {
        return pacientesAtuais;
    }

    public void setPacientesAtuais(Integer pacientesAtuais) {
        this.pacientesAtuais = pacientesAtuais;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especialista other = (Especialista) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Especialista{" + "id=" + id + ", nome=" + nome + ", especialidade=" + especialidade + ", valorSessao=" + valorSessao + ", duracao=" + duracao + ", maxPacientes=" + maxPacientes + ", pacientesAtuais=" + pacientesAtuais + ", registroProfissional=" + registroProfissional + '}';
    } 
}
