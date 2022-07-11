import javax.swing.*;

public class Usuario extends Cliente{

    private String tipo_cta;

    public Usuario(String tipo_cta, int numCta, String password, String nombre, double monto) {
        super(numCta, password, nombre,monto);
        this.tipo_cta = tipo_cta;
    }

    public String getTipo_cta() {
        return tipo_cta;
    }

    public void setTipo_cta(String tipo_cta) {
        this.tipo_cta = tipo_cta;
    }

    public void mostrarDatos (){
        JOptionPane.showMessageDialog( null,"DATOS USUARIO" +
                "\nNombre: "+getNombre()+
                "\nNumero de cuenta : "+getNumCta()+
                "\nTipo de cuenta: "+getTipo_cta()+"" +
                "\nMonto: "+getMonto());

    }
}
