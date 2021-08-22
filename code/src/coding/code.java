package coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = 0;//用来记录轮数， 总共10轮，前面9轮最多2次，第十轮可以有3次，连续三次10都可以
        int num = 0;//用来记录次数
        int strike = 3; //一轮的第一次就打完10个 ，本轮分数是本轮一次打桩数+后面两次打桩数
        int spare = 2; //一轮的两次来打完10个，本轮分数是本轮两次打桩和+下一次打桩数
        int normal = 1; //一轮的两次都没打完10个,本轮分数是两次打桩之和；如果是第10轮，还会额外增加一次滚球，第10轮分数等于3次打桩和
        int status1 = 0, status2 = 0, status = 0, beat = 0, s = 0, totalScore = 0;
        int[] sum = new int[10];
        int total = 0;
        int[][] result = new int[10][3];
        int[] down = new int[20];
        for (int i = 0; i < 20; i++)
            down[i] = sc.nextInt();  //获得20次的打桩数
        for (int i = 0; i < 20; i++) {
            beat = down[i];
            if (round < 9) { //即前9轮，因为result中索引从0开始，所以这边是小于9
                if (beat == 10) {  //如果打了10
                    result[round++][num] = beat;//进入下一轮
                    continue;
                    //s += 10;
                } else if (beat >= 0 && beat < 10) {
                    result[round][num++] = beat;
                    //s += beat;
                    if (num == 2) {
                        round++;
                        num = 0;
                    }

                }

//                if (num == 0 && s == 10) //一轮的第一次就是10
//                    status = strike;
//                else if (num == 2 && s == 10) //一轮中两次共到10
//                    status = spare;
//                else if (num == 2 && s < 10) { //一轮中两次加起来不到十
//                    status = normal;
//                    sum[round] = s;
//                }
//                status1 = status2;
//                status2 = status;
//                if (num == 2)
//                    num = 0;
//            } else {                  //round=9  也就是第10轮
//                if (num == 0)
//                    s = 0;
//                result[round][num++] = beat;
//                s += beat;
//            }
//            if (round >= 2) {  //也就是大于等于第三轮
//                if (status1 == strike && status2 == strike) { //10    10     1 2
//                    sum[round - 2] = 20 + result[round][0];
//                } else if (status1 == strike && status2 < strike) { //10     4 6 或 4 4      1 2
//                    sum[round - 2] = 10 + result[round - 1][0] + result[round - 1][1];
//                } else if (status1 == spare) { //4 6     10或 4 6或 4 4        1 2
//                    sum[round - 2] = 10 + result[round - 1][0];
//                }
//            }
            } else {
                result[round][num++] = beat;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (i < 9) {
                if (result[i][0] == 10) {
                    if (result[i + 1][0] == 10) {
                        if (i < 8) {
                            total += 20 + result[i + 2][0];
                        } else {
                            total += 20;
//                        }else if() {
//                            total+=10+result[i+1][0]+result[i+1][1];
//                        }
                        }

                        } else {
                            total += 10 + result[i + 1][0] + result[i + 1][1];
                        }
                    } else if (result[i][0] != 10) {
                        total += 10 + result[i + 1][0];

                    } else {
                        total += result[i][0] + result[i][1];
                    }
                } else {
                    if (result[i][1] == 10)
                        total += 20 + result[i][2];
                    else if (result[i][i] != 10)
                        total += 10 + result[i][2];
                }

            }
//        for (int i = 0; i < num; i++) { //计算的是第十轮的总打桩数
//            sum[9] += result[9][i];
//        }
//        //最后的status1指向result[7], status2指向result[8]
//        if (status2 == strike)
//            sum[8] = 10 + result[9][0] + result[9][1];
//        if (status2 == spare)
//            sum[8] = 10 + result[9][0];
//        else
//            sum[8] = result[8][0] + result[8][1];
//        for (int i = 0; i < 10; i++)
//            totalScore += sum[i];
//        System.out.println(totalScore);
            //

            // 1 2 3 4 5 6 7 8 8 10 6 7 8 8 5 4 3 3 6 7
//    int normal=1;
//	 int spare=2;
//	 int strike=3;
//        int game[]=new int[10];//数组存储各轮得分
//        int state1=0,state2=0;//上两轮的状态
//        int i,score,state;//i为循环变量，score存储当前得分，state为本轮状态
//        int totalscore=0;//总得分
//        for(i=0;i<10;i++){//计算每轮得分
//            score= sc.nextInt();//第一轮击球分数
//            if(score<0&&score>10){
//                return;
//            }
//            game[i]=score;//存储进数组
//            if(state2==strike&&state1==strike){//如果上两轮状态都为“strike”
//                game[i-2]=game[i-2]+score;// 求上两轮的得分
//            }
//            if(state1>=spare){
//                game[i-1]=game[i-1]+score;
//            }
//            if(score==10){
//                state=strike;
//            }
//            else{
//                score= sc.nextInt();
//                if(score<0&&score>10){
//                    return;
//                }
//                game[i]=game[i]+score;
//                if(game[i]==10){
//                    state=spare;
//                }else{
//                    state=normal;
//                }
//                if(state1==strike){
//                    game[i-1]=game[i-1]+score;
//
//                }
//                state2=state1;
//                state1=state;
//            }
//        }
//        if(state1==spare){
//            score= sc.nextInt();
//            if(score<0&&score>10){
//                return;
//            }
//            game[9]=game[9]+score;
//        }
//        else if(state1==strike){
//            score= sc.nextInt();
//            if(score<0&&score>10){
//                return;
//            }
//            game[9]=game[9]+score;
//            if(state2==strike){
//                game[8]=game[8]+score;
//            }
//            score= sc.nextInt();
//            if(score<0&&score>10){
//                return;
//            }
//            game[9]=game[9]+score;
//        }
//        for(i=0;i<10;i++){
//            System.out.println(game[i]);
//            totalscore+=game[i];
//        }
//        System.out.println(totalscore);

            // 1 2 3 4 5 6 7 8 8 10 6 7 8 8 5 4 3 3 6 7


        }

    }


