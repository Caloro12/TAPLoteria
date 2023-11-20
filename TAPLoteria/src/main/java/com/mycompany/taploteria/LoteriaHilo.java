/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taploteria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoteriaHilo extends Thread {
    private ImageIcon[] loteria;
    private JLabel resultLabel;

    public LoteriaHilo(String name, JLabel resultLabel) {
        super(name);
        this.loteria = new ImageIcon[6]; // Cambiar el tamaño según la cantidad de imágenes necesarias
        this.resultLabel = resultLabel;
    }

    public ImageIcon[] getLotteryCards() {
        return loteria;
    }

    @Override
    public void run() {
        initializeLotteryCards();
        displayResult();
    }

    private void initializeLotteryCards() {
        // Modifica estas rutas según la ubicación de tus imágenes en tu computadora
        String[] imagePaths = {
                "C:\\Users\\lolma\\Documents\\NetBeansProjects\\TAPLoteria\\LOTERIA\\1.png",
                "C:\\Users\\lolma\\Documents\\NetBeansProjects\\TAPLoteria\\LOTERIA\\2.png",
                "C:\\Users\\lolma\\Documents\\NetBeansProjects\\TAPLoteria\\LOTERIA\\3.png",
                "C:\\Users\\lolma\\Documents\\NetBeansProjects\\TAPLoteria\\LOTERIA\\4.png",
                "C:\\Users\\lolma\\Documents\\NetBeansProjects\\TAPLoteria\\LOTERIA\\5.png",
        };

        for (int i = 0; i < 6 && i < imagePaths.length; i++) {
            loteria[i] = new ImageIcon(getClass().getResource(imagePaths[i]));
        }
    }

    private void displayResult() {
        SwingUtilities.invokeLater(() -> {
            for (ImageIcon cardImage : loteria) {
                resultLabel.setIcon(cardImage);
                try {
                    Thread.sleep(1000); // Mostrar cada carta durante 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            resultLabel.setIcon(null); // Limpiar la imagen al final
        });
    }
}
