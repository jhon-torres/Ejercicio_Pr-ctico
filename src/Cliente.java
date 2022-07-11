public class Cliente {
    private int NumCta;
    private String password;
    private String Nombre;
    private double monto;

    public Cliente(int numCta, String password, String nombre, double monto) {
        NumCta = numCta;
        this.password = password;
        Nombre = nombre;
        this.monto = monto;
    }

    public int getNumCta() {
        return NumCta;
    }

    public void setNumCta(int numCta) {
        NumCta = numCta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
