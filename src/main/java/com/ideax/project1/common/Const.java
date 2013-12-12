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
    //-------------
    public static final Map<Integer, String> page_files = new HashMap<Integer, String>();
    static {
        page_files.put(PAGE_INDEX, "index.html");
    }
}
