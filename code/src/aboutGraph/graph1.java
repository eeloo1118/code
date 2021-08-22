package aboutGraph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class graph1 {
    ArrayList<String> vertextList;
    int numsOfEdges=0; //表示边的条数
    int [][]edge; //表示邻接矩阵
    public static void main(String []args){
        int n=5;
        String vertexs[]={"A","B","C","D","E"};
        graph1 graph=new graph1(n);//创建一个图对象
        for(String vertex: vertexs){
            graph.insertVertex(vertex);
        }
        graph.insert_char_Edge("A","B",1);
        graph.insert_char_Edge("A","D",1);
        graph.insert_char_Edge("B","C",1);
        graph.insert_char_Edge("B","D",1);
        graph.insert_char_Edge("D","E",1);
        graph.showGraph();

    }
    public graph1(int n){
        edge= new int[n][n];
        vertextList= new ArrayList<String>(n);
        numsOfEdges=0;

    }
    public void insertVertex(String vertex){
        vertextList.add(vertex);

    }
    public void insert_char_Edge(String a,String b,int i){
        int v1=vertextList.indexOf(a);
        int v2=vertextList.indexOf(b);
        edge[v1][v2]=i;
        edge[v2][v1]=i;
        numsOfEdges++;
    }

    public void showGraph(){
        for(int[] list: edge){
            System.out.println(Arrays.toString(list));

        }
    }


}
