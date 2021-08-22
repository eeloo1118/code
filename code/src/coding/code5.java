package coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code5 {
    public static void main(String[]args){
        List list= new ArrayList<>();
        list.add(1);
        list.add("aaa");
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"abc");
        list.add(map);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
