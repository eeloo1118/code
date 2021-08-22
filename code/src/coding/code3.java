package coding;
import java.util.*;
//创邻科技笔试第一题
public class code3 {
    public static  void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int up=Integer.parseInt(sc.nextLine());
        String strs[]= sc.nextLine().split(" ");
        int sum=0;
        int nums[]=new int[strs.length],i=0;
        for(String str:strs)
             nums[i++]=Integer.parseInt(str);
        for(int m=0;m< strs.length-1;m++){
            for(int n=0;n<strs.length-1-m;n++){
                int temp=nums[n];
                if(nums[n]>nums[n+1]){
                    nums[n]=nums[n+1];
                    nums[n+1]=temp;
                }
            }
        }
        //Arrays.sort(nums);
        for(int num:nums){
            if(sum+num<up)
                sum+=num;
            else
                break;
        }
        System.out.println(sum);
    }
}
