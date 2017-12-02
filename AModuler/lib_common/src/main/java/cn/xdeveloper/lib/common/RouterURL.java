package cn.xdeveloper.lib.common;

/**
 * <pre>
 *     author : Laiyimin
 *     time   : 2017/11/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class RouterURL {

    /**
     * module_main
     */
    public static class MainModule {

        //模块包名
        public static final String PACKAGE_NAME = "cn.xdeveloper.module.main";
        //初始化
        public static final String CREATE = "/main/create";
        //注入
        public static final String INJECT = "/main/inject";
    }

    /**
     * module_zhihu
     */
    public static class ZhihuModule {

        //模块包名
        public static final String PACKAGE_NAME = "cn.xdeveloper.module.zhihu";
        //初始化
        public static final String CREATE = "/zhihu/create";
        //注入
        public static final String INJECT = "/zhihu/inject";

        //日报
        public static final String DAILY = "/zhihu/daily";
    }

    /**
     * module_gank
     */
    public static class GankModule {

        //模块包名
        public static final String PACKAGE_NAME = "cn.xdeveloper.module.gank";
        //初始化
        public static final String CREATE = "/gank/create";
        //注入
        public static final String INJECT = "/gank/inject";

        //女孩
        public static final String GIRL = "/gank/girl";
    }

    /**
     * module_github
     */
    public static class GithubModule {

        //模块包名
        public static final String PACKAGE_NAME = "cn.xdeveloper.module.github";
        //初始化
        public static final String CREATE = "/github/create";
        //注入
        public static final String INJECT = "/github/inject";
    }
}
