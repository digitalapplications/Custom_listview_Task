package com.example.hp.custom_listview_task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 9/29/2016.
 */
public class DataProvider {

    private static List<Students> data = new ArrayList<>();
    public static List<Students> getData(){
        return data;
    }

    static {
        data.add(new Students(1001,"Hamad","Internee","BSE(Hons)","Android",0345123456));
        data.add(new Students(1002,"Fazal Nabi","Internee","BSE(Hons)","Android",0332123456));
        data.add(new Students(1003,"Ilyas","Internee","BSE(Hons)","Android",0313123456));
    }
}
