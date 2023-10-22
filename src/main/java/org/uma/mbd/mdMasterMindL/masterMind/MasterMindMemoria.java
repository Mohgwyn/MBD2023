package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.ArrayList;
import java.util.List;

public class MasterMindMemoria extends MasterMind{

    private List<Movimiento> movimientos;

    public MasterMindMemoria() {
        super();
        movimientos = new ArrayList<>();
    }
    public MasterMindMemoria(int longitud) {
        super(longitud);
        movimientos = new ArrayList<>();

    }

    @Override
    public Movimiento intento(String cifras) {
        Movimiento mov = super.intento(cifras);
        if (movimientos.contains(mov)) {
            throw new MasterMindException("This movement is repeated");
        }
        movimientos.add(mov);
        return mov;
    }

    public List<Movimiento> Movimientos() {
        return movimientos;
    }
}
