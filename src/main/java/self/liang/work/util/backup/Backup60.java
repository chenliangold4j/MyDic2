package self.liang.work.util.backup;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Backup60 {

    private static Map<String,String> needBackupDirs = new HashMap<>();



    public static void main(String[] args) throws IOException {
//        File file = new File("\\\\192.168.10.60\\Share\\代码\\Liang\\ke6k.txt");

        needBackupDirs.put("pinnacle","C:\\Users\\Administrator\\eclipse-workspace\\PinnacleFace\\pinnacle\\Liang");
//        needBackupDirs.put()


//        cpFileWithZip(needBackupDirs[0],"F:\\temporary","F:\\testmp4");

    }

    /**
     *
     *
     * @param sourceDir  原目录文件
     * @param zipTarget  压缩文件目录
     * @param uploadDir  上传文件目录
     * @return
     * @throws IOException
     */
    public static int cpFileWithZip(String sourceDir, String zipTarget,String uploadDir) throws IOException {
        //先压缩，再上传，文件名要处理
        File targetFile =    new File(zipTarget);
        String fileName = targetFile.getName();
        FileOutputStream fos1= new FileOutputStream(targetFile);
        ZipUtils.toZip(sourceDir, fos1,true);
        fos1.flush();
        fos1.close();
        cpFile(zipTarget,uploadDir);
        return 0;
    }

    public static int cpFile(String source, String targetDir) {
        File file = new File(source);
        if (file.exists()) {
            if (file.isDirectory()) {
                return -1;
            } else if (file.isFile()) {
                File targetFile = new File(targetDir + "/" + file.getName());
                System.out.println(targetDir + "/" + file.getName());
                FileInputStream fileInputStream = null;
                FileOutputStream fileOutputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    fileOutputStream = new FileOutputStream(targetFile);

                    byte[] buffer = new byte[2048];
                    int leng = fileInputStream.read(buffer);
                    while (leng>0){
                        fileOutputStream.write(buffer,0,leng);
                        leng =  fileInputStream.read(buffer);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
//        file.delete();
        return 0;
    }


}
