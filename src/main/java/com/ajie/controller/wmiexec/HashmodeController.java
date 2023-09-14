package com.ajie.controller.wmiexec;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HashmodeController {
    public HashmodeController(TextArea w_h_area, TextField w_h_cmd, TextField w_h_ip, TextField w_h_hash, TextField w_h_user) {
        String ip = w_h_ip.getText();
        String user = w_h_user.getText();
        String hash = w_h_hash.getText();
        String cmd = w_h_cmd.getText();
        try {
            String pluginPath = System.getProperty("user.dir") + "/plugins/examples/wmiexec.py";
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
                w_h_area.appendText(line + "\n");
            }
            reader.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
