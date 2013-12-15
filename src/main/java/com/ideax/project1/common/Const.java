package com.ideax.project1.common;

import java.util.HashMap;
import java.util.Map;

public class Const {

    // --------block group-------
    // public static final Map<Integer, String> blocks_desc = new
    // HashMap<Integer, String>();
    // --------- page ---------
    public static final int PAGE_INDEX = 1;
    public static final int PAGE_VIEW_NEWS = 2;
    // 国际 国内 军事 台海 评论财经 科技 博览 旅游 娱乐 体育 健康 图片 专题
    public static final int PAGE_PINDAO = 3;
    public static final int PAGE_LANMU = 4;
    //-------------
    public static final Map<Integer, String> page_files = new HashMap<Integer, String>();
    static {
        page_files.put(PAGE_INDEX, "index.html");
    }
}
