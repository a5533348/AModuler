package cn.xdeveloper.mvp.plugin.action;

import cn.xdeveloper.mvp.plugin.MvpGenerator;
import cn.xdeveloper.mvp.plugin.MyDialog;
import com.intellij.openapi.ui.Messages;

/**
 * Created by laiyimin on 2017/11/24.
 */
public class MVPFragmentAction extends MVPActivityAction {


    /**
     * 初始化Dialog
     *
     * @param dirPath
     */
    @Override
    protected void init(final String dirPath) {
        MyDialog myDialog = new MyDialog(new MyDialog.DialogCallBack() {
            @Override
            public void ok(String moduleName) {
                new MvpGenerator(moduleName, false, dirPath, packageName).start();
                Messages.showInfoMessage(project, "create mvp code success", "title");
            }
        });
        myDialog.setVisible(true);

    }


}
