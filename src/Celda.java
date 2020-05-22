public class Celda implements Cloneable{
    private Integer posicionX;
    private Integer posicionY;
    private Boolean estado;

    public Celda(){

    }

    public Celda(Integer posicionX, Integer posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Integer getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(Integer posicionX) {
        this.posicionX = posicionX;
    }

    public Integer getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(Integer posicionY) {
        this.posicionY = posicionY;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Object clone(){
        Celda obj=null;
        try{
            obj=(Celda)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
}
