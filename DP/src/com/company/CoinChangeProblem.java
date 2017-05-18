package com.company;


import java.util.Scanner;

public class CoinChangeProblem {
    private Integer[] input;

    public void runAlgorithm(){
        getInput();
        System.out.println(input[0] + " "+ input[1] + " "+ input[2]);
        System.out.println(naive(input[0])-1);
    }

    private void getInput(){
        Scanner input = new Scanner(System.in);
        String inputData = input.nextLine();
        this.input = new Integer[inputData.split(" ").length];

        String[] inputArray = inputData.split(" ");
        for(int i=0;i<inputArray.length;++i) {
            this.input[i] = Integer.parseInt(inputArray[i]);
        }
    }

    private int naive(int sum){
        //int index = -1;
        Integer minRet = Integer.MAX_VALUE;

      //  System.out.println(sum);
        if(sum < 0){
            return Integer.MAX_VALUE;
        }
        if(sum == 0){
            return 1;
        }

        for(int i=1;i<input.length;++i){
            Integer ret = naive(sum-input[i]);
            if(ret < minRet){
                minRet = ret;
            }
        }

        return (minRet==Integer.MAX_VALUE)?minRet:minRet+1;
    }
}
