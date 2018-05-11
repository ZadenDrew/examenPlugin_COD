/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.examCod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.org.examCod.holamundo"
)
@ActionRegistration(
        iconBase = "com/org/examCod/icon.png",
        displayName = "#CTL_holamundo"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 0)
    ,
  @ActionReference(path = "Toolbars/File", position = 0)
})
@Messages("CTL_holamundo=Hola")
public final class holamundo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando="javapackager -deploy -native deb -Bcategory=Education"+" -Bicon= "+JOptionPane.showInputDialog("dirección de la imagen")+"-BlicenseType=Propietary" + "-outdir .-outfile"+JOptionPane.showInputDialog("Nombre de la aplicación")+"-srcdir . -srcfiles "+ JOptionPane.showInputDialog("Nombre de la aplicación")+".jar -appclass"+JOptionPane.showInputDialog("Nombre del paquete . nombre aplicación")+"-name" +JOptionPane.showInputDialog("Nombre de la aplicación")+ "-title"+JOptionPane.showInputDialog("titulo de la aplicación");
        try {
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            Process pr = rt.exec("touch Holamundo.txt");

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (Exception ex) {
            System.out.println(e.toString());
            ex.printStackTrace();
        }
    }
}
