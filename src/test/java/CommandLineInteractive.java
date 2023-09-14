import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineInteractive {

    public CommandLineInteractive() {
        String pluginPath = System.getProperty("user.dir") + "/plugins/examples/psexec.py";
        ArrayList<String> cmd = new ArrayList<>();
        cmd.add("python3");
        cmd.add(pluginPath);
        cmd.add("administrator:1qaz@WSX@172.16.183.172");

        try {
            Process process = new ProcessBuilder(cmd)
                    .redirectErrorStream(true)
                    .start();

            // 获取进程的输入流和输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            OutputStream outputStream = process.getOutputStream();

            // 创建一个新的线程来读取进程的输出并打印到控制台
            Thread outputThread = new Thread(() -> {
                String line;
                try {
                    while ((line = reader.readLine()) != null) {
                        if (!line.startsWith(">")) {
                            // 使用正则表达式匹配并替换 "C:\\Windows\\system32>"
                            String replacedLine = replacePrompt(line);
                            System.out.println(replacedLine);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outputThread.start();

            // 创建一个Scanner对象用于读取用户输入的命令
            Scanner scanner = new Scanner(System.in);

            // 通过输出流向进程发送命令
            String command;
            while (true) {
                command = scanner.nextLine();
                if (command.equals("exit")) {
                    break;
                }
                command += System.lineSeparator();
                outputStream.write(command.getBytes());
                outputStream.flush();
                System.out.print("C:\\Windows\\system32> " + command);  // 显示命令提示符
            }

            // 等待命令行操作完成
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);

            // 关闭输入输出流
            outputStream.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String replacePrompt(String line) {
        String pattern = "^C:\\\\Windows\\\\system32>";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(line);
        return matcher.replaceFirst("");
    }
}


