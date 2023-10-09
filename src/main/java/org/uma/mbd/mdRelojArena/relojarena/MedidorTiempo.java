package org.uma.mbd.mdRelojArena.relojarena;

public class MedidorTiempo {

        private RelojArena izdo, drcho;
        private static int tiempoTotal = 0;

        public MedidorTiempo(int capIzdo, int capDrcho) {
                izdo = new RelojArena(capIzdo);
                drcho = new RelojArena(capDrcho);
        }

        public void giraDerecho() {
                drcho.gira();
                pasaTiempo();
        }
        public void giraIzquierdo() {
                izdo.gira();
                pasaTiempo();
        }
        public void giraAmbos() {
                drcho.gira();
                izdo.gira();
                pasaTiempo();
        }
        public void pasaTiempo() {
                if (drcho.getTiempoRestante()==0 ) {
                        tiempoTotal += izdo.getTiempoRestante();
                        drcho.pasaTiempo(izdo);
                } else if ( izdo.getTiempoRestante() == 0 ) {
                        tiempoTotal += drcho.getTiempoRestante();
                        drcho.pasaTiempo(drcho);
                } else if (izdo.getTiempoRestante() < drcho.getTiempoRestante()) {
                        tiempoTotal += izdo.getTiempoRestante();
                        drcho.pasaTiempo(izdo);
                } else {
                        tiempoTotal += drcho.getTiempoRestante();
                        drcho.pasaTiempo(drcho);
                }
        }
        public int getTiempoTotal() { return tiempoTotal; }
        @Override
        public String toString() {
                return "Izquierdo: " + izdo + ", Derecho: " + drcho;
        }

}
