package coding;
import java.util.Arrays;
import java.util.Comparator;
//重写compare,实现sort降序排列
public class code1 {
    public static  void main(String[] args){
        Integer a[]=new Integer[]{1,2,3};
        Arrays.sort(a,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return -1;
                else if(o1<o2) return 1;
                else
                    return 0;
            }
        });
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
