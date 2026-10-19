package Practica_3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Practica_3 extends JFrame
{
    //Valores para los campos de texto
    private int numero = 0;
    private int edad = 0;
    private String nombre = "";
    private int puntos = 0;
    
    //Attay e indice
    private Cliente[] clientes;
    private int indice = 0;
    
    //Etiquetas para identificar los campos de texto
    private JLabel LNumero;
    private JLabel LNombre;
    private JLabel LEdad;
    private JLabel LPuntos;
    
    
    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;
    
    //Los button
    private JButton botonAnterior, botonSiguiente;
    
    
    public Practica_3(Cliente[] clientes) {
        super("Practica_3");
        this.clientes = clientes;
        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea las etiquetas.
        LNumero = new JLabel("Numero: ");
        LNombre = new JLabel("Nombre: ");
        LEdad = new JLabel("Edad: ");
        LPuntos = new JLabel("Puntos: ");
        
        //Campo donde vamos a introducir el número
        numeroField = new JTextField(10);
        edadField = new JTextField(10);
        puntosField = new JTextField(10);
        nombreField = new JTextField(10);
        
        //Todos falsos
        numeroField.setEditable(false);
        nombreField.setEditable(false);
        edadField.setEditable(false);
        puntosField.setEditable(false);

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(LNumero);
        labelPane.add(LNombre);
        labelPane.add(LEdad);
        labelPane.add(LPuntos);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);
        
        /*LOS BOTONES CON SU PANE*/
        botonAnterior = new JButton("Anterior");
        botonSiguiente = new JButton("Siguiente");
        botonAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indice > 0) {
                    indice--;
                    mostrarCliente();
                }
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indice < Practica_3.this.clientes.length - 1) {
                    indice++;
                    mostrarCliente();
                }
            }
        });
        
        JPanel botonPane = new JPanel();
        botonPane.setLayout(new GridLayout(1, 0));
        botonPane.add(botonAnterior);
        botonPane.add(botonSiguiente);
        
        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
               BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(botonPane, BorderLayout.SOUTH);

        setContentPane(contentPane);  //this.setContentPane(contentPane);
          // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame
        mostrarCliente();   // muestra el primer cliente al abrir
    }

    public static void main(String[] args) {
        final Cliente[] clientes = new Cliente[3];
        clientes[0] = new Cliente(1, 20, "Pepe", 100);
        clientes[1] = new Cliente(2, 22, "Carla", 200);
        clientes[2] = new Cliente(3, 24, "Jose", 100);
        
        
        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Practica_3 app = new Practica_3(clientes);

                //Este WindowListener ya solo sirve para poner el foco.
                //(Para cerrar la ventana ya no hace falta: setDefaultCloseOperation.)
                app.addWindowListener(new WindowAdapter() {
                    //Pone el focus (foco de atencion)
                    
                });
                app.pack();
                app.setVisible(true);
            }
        });
    }
    
    //Rellena los campos con el cliente actual y activa/desactiva los botones
    private void mostrarCliente() {
        Cliente c = clientes[indice];
        numeroField.setText(String.valueOf(c.getNumero()));
        nombreField.setText(c.getNombre());
        edadField.setText(String.valueOf(c.getEdad()));
        puntosField.setText(String.valueOf(c.getPuntos()));

        botonAnterior.setEnabled(indice > 0);
        botonSiguiente.setEnabled(indice < clientes.length - 1);
    }

}
