package cn.xdeveloper.mvp.plugin;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by laiyimin on 2017/11/24.
 */
public class MvpGenerator {

    private String moduleName;
    private boolean isActivity;
    private String dirPath;
    private String packageName;

    public MvpGenerator(String moduleName, boolean isActivity, String dirPath, String packageName) {
        this.moduleName = moduleName;
        this.isActivity = isActivity;
        this.dirPath = dirPath;
        this.packageName = packageName;
    }


    public void start() {

        if (isActivity) {
            createClassFile(CodeType.Activity);
        } else {
            createClassFile(CodeType.Fragment);
        }
        createClassFile(CodeType.Contract);
        createClassFile(CodeType.Presenter);
        createClassFile(CodeType.Module);
    }


    /**
     * 生成mvp框架代码
     *
     * @param codeType
     */
    private void createClassFile(CodeType codeType) {
        String fileName = "";
        String content = "";

        String path = dirPath.replaceAll("/", ".").replaceAll("\"", ".");

        String targetPackageName = path.substring(path.indexOf(packageName)) + (moduleName + "").toLowerCase();

        switch (codeType) {
            case Activity:
                fileName = "TemplateActivity.txt";
                content = ReadTemplateFile(fileName);
                content = dealTemplateContent(content, targetPackageName);

                writeToFile(content, dirPath + moduleName.toLowerCase(), moduleName + "Activity.java");
                break;
            case Fragment:
                fileName = "TemplateFragment.txt";
                content = ReadTemplateFile(fileName);
                content = dealTemplateContent(content, targetPackageName);
                writeToFile(content, dirPath + moduleName.toLowerCase(), moduleName + "Fragment.java");
                break;
            case Contract:
                fileName = "TemplateContract.txt";
                content = ReadTemplateFile(fileName);
                content = dealTemplateContent(content, targetPackageName);
                writeToFile(content, dirPath + moduleName.toLowerCase(), moduleName + "Contract.java");
                break;
            case Presenter:
                fileName = "TemplatePresenter.txt";
                content = ReadTemplateFile(fileName);
                content = dealTemplateContent(content, targetPackageName);
                writeToFile(content, dirPath + moduleName.toLowerCase(), moduleName + "Presenter.java");
                break;
            case Module:
                fileName = "TemplateModule.txt";
                content = ReadTemplateFile(fileName);
                content = dealTemplateContent(content, targetPackageName);
                writeToFile(content, dirPath + moduleName.toLowerCase(), moduleName + "Module.java");
                break;
        }
    }


    /**
     * 替换模板中字符
     *
     * @param content
     * @return
     */
    private String dealTemplateContent(String content, String packageName) {
        String injectType = isActivity ? "Activity" : "Fragment";

        //首字母小写的ModuleName
        content = content.replace("$name", moduleName)
                .replace("$sname", moduleName.toLowerCase())
                .replace("$injectType", injectType)
                .replace("$packagename", packageName);


        return content;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return formatter.format(currentTime);
    }


    /**
     * 读取模板文件中的字符内容
     *
     * @param fileName 模板文件名
     * @return
     */
    private String ReadTemplateFile(String fileName) {
        InputStream in;
        in = this.getClass().getResourceAsStream("Template/" + fileName);
        String content = "";
        try {
            content = new String(readStream(in));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }


    private byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }

        return outputStream.toByteArray();
    }


    /**
     * 生成
     *
     * @param content   类中的内容
     * @param classPath 类文件路径
     * @param className 类文件名称
     */
    private void writeToFile(String content, String classPath, String className) {
        try {
            File floder = new File(classPath);
            if (!floder.exists()) {
                floder.mkdirs();
            }

            File file = new File(classPath + "/" + className);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getPackageName(String basePath) {
        File file = new File(basePath, "gradle.properties");
        if (!file.exists()) {
            return null;
        }

        Properties pro = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pro.getProperty("packageName");
    }

    public static void main(String args[]) {
        String str = "src.java.main.com.gyenno.cloud.main";
        System.out.println(str.substring(str.indexOf("com.gyenno")));


    }
}
