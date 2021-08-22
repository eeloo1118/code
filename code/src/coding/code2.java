package coding;
import  java.util.*;
public class code2 {
    public static  void main(String[]args){
        char[][] matrix= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix1= {{'1','1'},{'1','1'}};


      int res=maximalSquare(matrix1);
//       for(int i=0;i<2;i++){
//           for(int j=0;j<2;j++){
//               System.out.print(matrix1[i][j]);
//
//           }
//           System.out.println();
//
//       }
        System.out.println(res);

    }
    public static int maximalSquare(char[][] matrix) {
        int res=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    int level=1;
                    int row=i+1,column=j+1;
                    while(row<matrix.length&&column<matrix[0].length){
                        int flag=1;
                        if(matrix[row][column]=='1'){
                            for(int m=i;m<row;m++)
                                if(matrix[m][column]!='1'){
                                    flag=0;
                                    break;
                                }
                            if(flag==1)
                                for(int m=j;m<column;m++){
                                    if(matrix[row][m]!='1'){
                                        flag=0;
                                        break;
                                    }
                                }
                            if(flag==1)
                                level++;
                        }
                        else
                            break;
                    }
                    res=Math.max(res,level);
                }

            }
        }
        return res;

    }
}
