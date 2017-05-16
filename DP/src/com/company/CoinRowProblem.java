package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CoinRowProblem {
    Integer [] input;

    public void runAlgorithm(){
        getInput();
        System.out.println(noDynamicProgramming(input,0));
    }

    private void getInput(){
        Scanner input = new Scanner(System.in);
        String inputData = input.nextLine();
        this.input = new Integer[inputData.split(" ").length];

        int i = 0;
        for (String num :inputData.split(" ")) {
            this.input[i] = Integer.parseInt(num);++i;
        }

    }

    private int DynamicProgramming(Integer[] Array, Integer index){

        return 0;
    }

    private int noDynamicProgramming(Integer []Array, Integer index){
        if(index >= Array.length){
            return 0;
        }
        else{
            return Array[index] + Integer.max(noDynamicProgramming(Array,index+2),noDynamicProgramming(Array,index+3));
        }
    }
}
