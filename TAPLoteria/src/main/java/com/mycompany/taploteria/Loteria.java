/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.taploteria;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loteria extends javax.swing.JFrame {

    private JLabel resultLabel;

    public Loteria() {
        super("Lotería Mexicana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        resultLabel = new JLabel("Resultados aquí", SwingConstants.CENTER);
        resultLabel.setVerticalTextPosition(SwingConstants.TOP);

        JButton startButton = new JButton("Iniciar Lotería");
        startButton.addActionListener(e -> iniciarLoteria());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(resultLabel, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        add(panel);
    }
    private void iniciarLoteria() {
        int hilos = 1;
        LoteriaHilo[] loteriahilo = new LoteriaHilo[hilos];

        // Crear hilos de lotería
        for (int i = 0; i < hilos; i++) {
            loteriahilo[i] = new LoteriaHilo("Thread-" + (i + 1), resultLabel);
        }

        // Iniciar los hilos
        for (LoteriaHilo thread : loteriahilo) {
            thread.start();
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        SwingUtilities.invokeLater(() -> {
            Loteria loteria = new Loteria();
            loteria.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
