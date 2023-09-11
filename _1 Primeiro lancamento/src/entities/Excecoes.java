package entities;

import java.io.Serial;

public class Excecoes extends java.lang.Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public Excecoes(String msg){
        super(msg);
    }
}
