import java.util.ArrayList;

public class Reglas {
    public Malla aplicarReglas(Malla mallaOrig) {
        Malla mallaResult = new Malla();
        mallaResult.setAltura(mallaOrig.getAltura());
        mallaResult.setAncho(mallaOrig.getAncho());
        mallaResult.setCampo(new ArrayList<Celda>());
        for(Celda celdaOrig:mallaOrig.getCampo()){
            Celda celdaTemp = (Celda)celdaOrig.clone();
            int cant = 0;
            for(int i = celdaTemp.getPosicionX()-1;i<=celdaTemp.getPosicionX()+1;i++){
                for(int j = celdaTemp.getPosicionY()-1;j<=celdaTemp.getPosicionY()+1;j++){
                    if (i != celdaTemp.getPosicionX() || j != celdaTemp.getPosicionY()) {
                        for ( Celda celdaR:mallaOrig.getCampo()) {
                            if(celdaR.getPosicionX()==i &&celdaR.getPosicionY()==j){
                                cant += celdaR.getEstado()?1:0;
                            }
                        }
                    }
                }
            }
            if(cant<2) {
                celdaTemp.setEstado(false);
            }else if(cant==2){
                celdaTemp.setEstado(celdaTemp.getEstado());
            }else if(cant==3){
                celdaTemp.setEstado(true);
            }else if(cant>3){
                celdaTemp.setEstado(false);
            }
            mallaResult.getCampo().add(celdaTemp);
        }
        return mallaResult;
    }
}
