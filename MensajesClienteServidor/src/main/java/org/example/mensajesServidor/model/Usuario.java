package org.example.mensajesServidor.model;

public class Usuario {
    private int id;
    private String name;
    private String password;

    public Usuario(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
