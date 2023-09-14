package com.ajie.controller.psexec;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CiphermodeController {

    public CiphermodeController(TextArea p_m_area, TextField p_m_cmd, TextField p_m_ip, TextField p_m_pass, TextField p_m_user){

        String ip = p_m_ip.getText();
        String user = p_m_user.getText();
        String pass = p_m_pass.getText();
        String cmd = p_m_cmd.getText();
        try {
            String pluginPath = System.getProperty("user.dir") + "/plugins/examples/psexec.py";
            ArrayList<String> command = new ArrayList<>();
            command.add("python3");
            command.add(pluginPath);
            command.add(user + ":" + pass + "@" + ip);
            command.add(cmd);
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                p_m_area.appendText(line + "\n");
            }
            reader.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
