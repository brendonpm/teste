package com.example.teste;

public interface DaoInterface {

    void create(Pessoa pessoa);

    Pessoa recover(String id);

    void update(Pessoa pessoa);

    void delete(Pessoa pessoa);

}
