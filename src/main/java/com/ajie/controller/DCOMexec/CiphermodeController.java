package com.ajie.controller.DCOMexec;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CiphermodeController {
    public CiphermodeController(TextArea d_m_area, TextField d_m_cmd, TextField d_m_ip, TextField d_m_pass, TextField d_m_user) {

        String ip = d_m_ip.getText();
        String user = d_m_user.getText();
        String pass = d_m_pass.getText();
        String cmd = d_m_cmd.getText();
        try {
            String pluginPath = System.getProperty("user.dir") + "/plugins/examples/dcomexec.py";
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
                d_m_area.appendText(line + "\n");
            }
            reader.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
