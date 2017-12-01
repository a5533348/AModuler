package cn.xdeveloper.mvp.plugin.action;

import cn.xdeveloper.mvp.plugin.MvpGenerator;
import cn.xdeveloper.mvp.plugin.MyDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by laiyimin on 2017/11/24.
 */
public class MVPActivityAction extends AnAction {

    protected Project project;
    protected String packageName;

    @Override
    public void actionPerformed(AnActionEvent e) {
        project = e.getData(PlatformDataKeys.PROJECT);
        packageName = MvpGenerator.getPackageName(project.getBasePath());

        if (packageName == null || "".equals(packageName)) {
            Messages.showInfoMessage(project, "请在项目跟目录的gradle.properties文件中配置packageName", "提示");
            return;
        }

        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        init(file.getPath().concat("/"));
        refreshProject();
    }

    /**
     * 刷新项目
     */
    private void refreshProject() {
        project.getBaseDir().refresh(false, true);
    }

    /**
     * 初始化Dialog
     */
    protected void init(final String dirPath) {
        MyDialog myDialog = new MyDialog(new MyDialog.DialogCallBack() {
            @Override
            public void ok(String moduleName) {

                new MvpGenerator(moduleName, true, dirPath, packageName).start();
                Messages.showInfoMessage(project, "create mvp code success", "提示");
            }
        });
        myDialog.setVisible(true);
    }


}
