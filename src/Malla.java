import java.util.ArrayList;
import java.util.List;

public class Malla implements Cloneable{
    private Integer ancho;
    private Integer altura;
    private List<Celda> campo;

    public Malla() {
    }

    public Malla(Integer ancho, Integer altura, List<Celda> celdasPoblada) {
        this.ancho = ancho;
        this.altura = altura;
        this.campo = new ArrayList<>();
        for(int i = 1;i <= this.ancho; i++){
            for(int j = 1; j <= this.altura;j++){
                Celda celda = new Celda(i,j);
                for(Celda celdaPoblada:celdasPoblada){
                    celda.setEstado(celdaPoblada.getPosicionX().equals(i) && celdaPoblada.getPosicionY().equals(j));
                    if(celda.getEstado()){break;}
                }
                this.campo.add(celda);
            }
        }
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public List<Celda> getCampo() {
        return campo;
    }

    public void setCampo(List<Celda> campo) {
        this.campo = campo;
    }

    public void pintarMalla(){
        for(int i = 1;i<=this.altura;i++){
            String nivel = "";
            for(int j = 1;j<=this.ancho;j++){
                for(Celda celda:this.campo){
                    nivel += (celda.getPosicionY()==i && celda.getPosicionX() == j)?(celda.getEstado()?"X ":"  "):"";
                }
            }
            System.out.println(nivel);
        }
    }

    public List<Celda> copiarListaCelda(){
        List<Celda> listCelda = new ArrayList<>();
        for(Celda celda:this.getCampo()){
            Celda obj = (Celda) celda.clone();
            listCelda.add(obj);
        }
        return listCelda;
    }

    public Object clone(){
        Malla obj=null;
        try{
            obj=(Malla)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        obj.campo = copiarListaCelda();
        return obj;
    }

}

