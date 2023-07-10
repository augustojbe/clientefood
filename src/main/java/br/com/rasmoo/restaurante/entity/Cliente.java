package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @EmbeddedId
    private ClienteId clienteId;

    private String nome;

    @Embedded
    private Contato contato;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();

    public String getCpf() {
        return clienteId.getCpf();
    }

    public Cliente() {
    }

    public Cliente(String cpf, String email, String nome) {
        ClienteId clienteId1 = new ClienteId(email, cpf);
        this.nome = nome;

    }

    public void addEndereco(Endereco endereco){
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public void getCpf(String cpf) {
        this.clienteId.setCpf(cpf);
    }

    public void setCpf(String cpf) {
        this.clienteId.setCpf(cpf);
    }

    public void getEmail(String email) {
        this.clienteId.setCpf(email);
    }

    public void setEmail(String email) {
        this.clienteId.setCpf(email);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + clienteId.getCpf() + '\'' +
                ", email='" + clienteId.getEmail() + '\'' +
                ", nome='" + nome + '\'' +
                ", contato=" + contato +
                ", enderecoList=" + enderecoList +
                '}';
    }
}
