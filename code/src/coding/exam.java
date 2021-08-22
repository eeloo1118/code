package coding;

import java.util.Scanner;

public class exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int totalScore = getTotalScore(str);
            System.out.println("totalScore: " + totalScore);
        }
    }

    public static int getScore(char ch) {
        if (ch >= '1' && ch <= '9') {
            return Integer.parseInt(ch + "");
        } else if (ch == '-')
            return 0;
        else if(ch=='X'){
            return 10;
        }
        return 0;
    }

    public static int getTotalScore(String str) {
        char[][] res = new char[10][3];
        int round = 0, totalScore = 0;
        int num = 0;
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (round < 9) {
                if (str.charAt(i) == 'X') {//投出10，直接进行下一轮
                    res[round++][num] = 'X';
                    continue;
                } else if ((str.charAt(i) >= '1' && str.charAt(i) <= '9') || str.charAt(i) == '-' || str.charAt(i) == '/') {
                    res[round][num++] = str.charAt(i);
                    if (num > 1) {
                        round++;
                        num = 0;
                    }
                }
            } else {     //第10轮
                res[round][a++] = str.charAt(i);
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (i < 9) {
                if (res[i][0] == 'X') {
                    if (res[i + 1][0] == 'X') {  //连续两轮都是strike的话
                        if (i < 8) {
                            totalScore += 20 + getScore(res[i + 2][0]);//小于8直接加
                        } else if (res[i + 1][1] == '/') {// =8时，也就是第9轮
                            totalScore += 20;
                        } else {
                            totalScore += 10 + getScore(res[i + 1][0]) + getScore(res[i + 1][1]);
                        }
                    } else if (res[i + 1][1] == '/') { //前一轮strike， 后一轮spare
                        totalScore += 20;
                    } else {             //前一轮strike,后一轮normal
                        totalScore += 10 + getScore(res[i + 1][0]) + getScore(res[i + 1][1]);
                    }
                } else if (res[i][1] == '/') {  //当前轮是spare ,奖励一次
                    totalScore += 10 + getScore(res[i + 1][0]);
                } else {  //当前轮是normal， 只加这两次之和
                    totalScore += getScore(res[i][0]) + getScore(res[i][1]);
                }
            } else {       //i=9的时候，也就是第10轮的时候 也要分情况
                if (res[i][1] == '/')//最后一轮第二次补中，会奖励一次
                    totalScore += 10 + getScore(res[i][2]);
                else if (res[i][1] == 'X')//最后一轮第二次全中 也会奖励
                    totalScore += 20 + getScore(res[i][2]);
                else {  //当res[i][1]为- 或数字的时候，
                    totalScore += getScore(res[i][1]) + getScore(res[i][0]);
                }
            }
            System.out.println(totalScore);
        }
        return totalScore;
    }

//X72X9/7-9/XX9/9-
// X7/368-XX8/637/9/X
}
