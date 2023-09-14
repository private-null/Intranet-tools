package com.ajie.controller.ATexec;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HashmodeController {
    public HashmodeController(TextArea a_h_area, TextField a_h_cmd, TextField a_h_ip, TextField a_h_hash, TextField a_h_user){
        String ip = a_h_ip.getText();
        String user = a_h_user.getText();
        String hash = a_h_hash.getText();
        String cmd = a_h_cmd.getText();
        try {
            String pluginPath = System.getProperty("user.dir") + "/plugins/examples/atexec.py";
            ArrayList<String> command = new ArrayList<>();
            command.add("python3");
            command.add(pluginPath);
            command.add("-hashes");
            command.add("00000000000000000000000000000000:" + hash);
            command.add(user + "@" + ip);
            command.add(cmd);
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                a_h_area.appendText(line + "\n");
            }
            reader.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
