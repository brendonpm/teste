package com.example.teste;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ImportJsonTeste {

    private ImportJson importJson;

    @Mock
    private DaoInterface dao;

    private Gson gson;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        gson = new Gson();
        importJson = new ImportJson(dao,gson);
    }

    @Test
    public void test_importaArquivo_comNomeDeArquivoValido() throws IOException, URISyntaxException {

        URI jsonUri = getClass().getResource("/valid_Json.json").toURI();
        File file = new File(jsonUri);
        importJson.importJsonFile(file.getAbsolutePath());

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("brendon");
        pessoa.setSobrenome("peixoto");
        System.out.print("nome2: " + pessoa.getNome() + " sobrenome2: " + pessoa.getSobrenome());
        Mockito.verify(dao).create(pessoa);
    }
}
