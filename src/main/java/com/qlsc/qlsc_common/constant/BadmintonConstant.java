package com.qlsc.qlsc_common.constant;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BadmintonConstant {
    public static int TYPE_VIP = 1;
    public static int TYPE_NORMAL = 2;
    public static List<Integer> listCourtType = new ArrayList<>(){
        {
            add(TYPE_VIP);
            add(TYPE_NORMAL);
        }
    };
    public static int STATUS_ON = 1;
    public static int STATUS_OFF = 0;
    public static List<Integer> listStatus = new ArrayList<>(){
        {
            add(STATUS_ON);
            add(STATUS_OFF);
        }
    };
}
