import javax.swing.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuario> usuario = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        /* PIDE EL NUMERO DE USUARIOS A INGRESAR */
        int num_user = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de clientes a registrar: ","Clientes",JOptionPane.QUESTION_MESSAGE));

        /* REGISTRO DE USUARIOS */
        for (int i=0; i< num_user;i++){
            String nombre = JOptionPane.showInputDialog(null,"Nombre del Titular: ","Registro Cliente"+(i+1),JOptionPane.QUESTION_MESSAGE);
            String tipo_cta = JOptionPane.showInputDialog(null,"Tipo de cuenta: ","Registro Cliente"+(i+1),JOptionPane.QUESTION_MESSAGE);
            int numcta = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de Cuenta: ","Registro Cliente"+(i+1),JOptionPane.QUESTION_MESSAGE));
            String pass = JOptionPane.showInputDialog(null,"Contraseña: ","Registro Cliente"+(i+1),JOptionPane.QUESTION_MESSAGE);
            double monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Monto de apertura: ","Registro Cliente"+(i+1),JOptionPane.QUESTION_MESSAGE));
            usuario.add(new Usuario(tipo_cta, numcta,pass,nombre,monto));

            /* ESCRITURA DE DATOS DE USUARIO EN usuarios.txt sin el tipo y contraseña*/
            try {
                PrintWriter miPr = new PrintWriter("usuarios.txt");

                miPr.println(usuario.get(i).getNumCta());
                miPr.println(usuario.get(i).getNombre());
                miPr.println(usuario.get(i).getTipo_cta());
                miPr.println((usuario.get(i).getMonto())+"\n");
                miPr.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }

        int numcta = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de Cuenta: ","Igresar Usuario",JOptionPane.QUESTION_MESSAGE));
        String pass = JOptionPane.showInputDialog(null,"Contraseña: ","Registro Cliente",JOptionPane.QUESTION_MESSAGE);

        /*buscar user mediante numero de cuenta*/
        int i=0;

        System.out.println(usuario.size());
        while (i<usuario.size()){
            /* encontrar el numcta en el arreglo junto a la contraseña */
            if (numcta == usuario.get(i).getNumCta()){
                if (pass == usuario.get(i).getPassword()){
                    usuario.get(i).mostrarDatos();
                    int opc=0;
                    while (opc != 3){

                       opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Menú de transformaciones:\n1. Depositar\n2. Retirar\n3. Salir","Transacciones",JOptionPane.QUESTION_MESSAGE));
                       switch (opc){
                           case 1:
                               JOptionPane.showMessageDialog(null, "El monto en tu cuenta es: "+usuario.get(i).getMonto());
                               double monto_depos = Double.parseDouble(JOptionPane.showInputDialog(null, "Monto a depositar: ","Depositar Monto en "+usuario.get(i).getNumCta(),JOptionPane.QUESTION_MESSAGE));
                               usuario.get(i).setMonto(usuario.get(i).getMonto() + monto_depos);
                               JOptionPane.showMessageDialog(null, "El nuevo monto en tu cuenta es: "+usuario.get(i).getMonto());
                               try {
                                   PrintWriter miPr = new PrintWriter("transacciones.txt");

                                   miPr.println(usuario.get(i).getNumCta());
                                   miPr.println(usuario.get(i).getNombre());
                                   miPr.println(usuario.get(i).getTipo_cta());
                                   miPr.println("Deposito: "+monto_depos);
                                   miPr.println((usuario.get(i).getMonto())+"\n");
                                   miPr.close();

                               } catch (Exception e) {
                                   e.printStackTrace();
                               }
                               break;
                           case 2:
                               JOptionPane.showMessageDialog(null, "El monto en tu cuenta es: "+usuario.get(i).getMonto());
                               double monto_ret = Double.parseDouble(JOptionPane.showInputDialog(null, "Monto a retirar: ","Retirar Monto en "+usuario.get(i).getNumCta(),JOptionPane.QUESTION_MESSAGE));
                               usuario.get(i).setMonto(usuario.get(i).getMonto() - monto_ret);
                               JOptionPane.showMessageDialog(null, "El nuevo monto en tu cuenta es: "+usuario.get(i).getMonto());
                               try {
                                   PrintWriter miPr = new PrintWriter("transacciones.txt");

                                   miPr.println(usuario.get(i).getNumCta());
                                   miPr.println(usuario.get(i).getNombre());
                                   miPr.println(usuario.get(i).getTipo_cta());
                                   miPr.println("Deposito: "+"-"+monto_ret);
                                   miPr.println((usuario.get(i).getMonto())+"\n");
                                   miPr.close();

                               } catch (Exception e) {
                                   e.printStackTrace();
                               }
                               break;

                       }
                    }
                }




            } else {
                JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
            }

            i++;
        }





    }
}
