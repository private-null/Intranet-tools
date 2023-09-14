package com.ajie.controller.wmiexec;


import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class CiphermodeController {

    public CiphermodeController( TextArea w_m_area, TextField w_m_cmd, TextField w_m_ip, TextField w_m_pass, TextField w_m_user) {
        String ip = w_m_ip.getText();
        String user = w_m_user.getText();
        String pass = w_m_pass.getText();
        String cmd = w_m_cmd.getText();

        try {
            String pluginPath = System.getProperty("user.dir") + "/plugins/examples/wmiexec.py";
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
                w_m_area.appendText(line + "\n");
            }
            reader.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
