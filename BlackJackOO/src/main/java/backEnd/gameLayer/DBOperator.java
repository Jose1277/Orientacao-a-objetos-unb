package backEnd.gameLayer;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DBOperator{
    private static final String arquivoDB = "players.json";
    private Map<String, Double> saldosJogadores;
    private Gson gson = new Gson();

    public DBOperator() {
        saldosJogadores = new HashMap<>(); // Initialize the map here
        saldosJogadores = carregarSaldosDoArquivo();
    }

    private Map<String, Double> carregarSaldosDoArquivo() {
        try (Reader reader = new FileReader(arquivoDB)) {
            Map<String, Double> fileData = gson.fromJson(reader, new TypeToken<Map<String, Double>>() {}.getType());
            if (fileData != null) {
                saldosJogadores.putAll(fileData); // Update the map with file data
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return saldosJogadores;
    }

    public void salvarSaldos() {
        try (Writer writer = new FileWriter(arquivoDB)) {
            gson.toJson(saldosJogadores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double buscarSaldo(String nomeJogador) {
        return saldosJogadores.getOrDefault(nomeJogador, 10.0);
    }

    public void atualizarSaldoJogador(String nomeJogador, double saldo) {
        saldosJogadores.put(nomeJogador, saldo);
        salvarSaldos();
    }
}
