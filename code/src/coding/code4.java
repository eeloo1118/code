package coding;
import java.util.*;
//创邻科技笔试第二题
public class code4 {
    public static  void main(String []args){
        String[] letters={"ABCDEFGHI","JKLMNOPQR","STUVWXYZ "};
        List<Integer> list= new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();//输入月份
        int n=sc.nextInt();//输入日子
        sc.nextLine(); //吃掉回车
        String str= sc.nextLine(); //输入字母
        String [] newLetters=new String[3];
        for(int i=0;i<3;i++){
            String s=letters[(i+m-1)%3];
            newLetters[i]=s;
            StringBuffer sb= new StringBuffer();
            for(int j=0;j<9;j++)
                sb.append(newLetters[i].charAt((j+n-1)%9));
            newLetters[i]=sb.toString();
        }
        for(int i=0;i<str.length();i++){
            for(int j=0;j<3;j++){
                if(newLetters[j].contains(str.charAt(i)+"")){
                    int group=j+1, pos=newLetters[j].indexOf(str.charAt(i)+"")+1;
                    list.add(group*10+pos);
                }
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
            if(i!=list.size()-1)
                System.out.print(" ");
        }
    }
}
