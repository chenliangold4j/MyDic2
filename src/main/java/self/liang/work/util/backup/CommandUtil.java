package self.liang.work.util.backup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandUtil {
    public static void main(String[] args) {
        String cmd = "ping www.baidu.com";
//        cmd /c dir 是执行完dir命令后关闭命令窗口。
//
//        cmd /k dir 是执行完dir命令后不关闭命令窗口。
//
//        cmd /c start dir 会打开一个新窗口后执行dir指令，原窗口会关闭。
//
//        cmd /k start dir 会打开一个新窗口后执行dir指令，原窗口不会关闭
        Runtime run = Runtime.getRuntime();
        try {
            // run.exec("cmd /k shutdown -s -t 3600");
            Process process = run.exec("cmd.exe /k  " + cmd);
            InputStream in = process.getInputStream();
            BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(in,"GBK"));
            String s = bufferedInputStream.readLine();
            while (s !=null) {
                System.out.println(s);
                s = bufferedInputStream.readLine();
            }
            in.close();
//            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
