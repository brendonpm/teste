package com.example.teste;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImportJson {

    public Gson gson;
    public DaoInterface dao;

    public ImportJson(DaoInterface dao, Gson gson) {
        this.gson = gson;
        this.dao = dao;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void importJsonFile(String fileName) throws IOException {
        File file = new File(fileName);

        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            String fileText = new String(bytes);

//        String str = new String();
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//
//        while(br.ready()){
//            str += br.readLine() + "\n";
//        }

            Pessoa pessoa = gson.fromJson(fileText, Pessoa.class);
            dao.create(pessoa);

            System.out.print("nome: " + pessoa.getNome() + " sobrenome: " + pessoa.getSobrenome());
        } catch (IOException e){
            e.printStackTrace();
        }
    }





}
