package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CoinRowProblem {
    private Integer [] input;
    private Integer [] solvedSubproblems;
    private long countRecursiveCalls = 0;

    public void runAlgorithm(){
        getInput();

        //Bottom Up
        System.out.println(BottomUp(input));
        System.out.println(countRecursiveCalls);
        System.out.println();


        //Top Down
        for (int i=0; i< solvedSubproblems.length;++i) {
            solvedSubproblems[i] = -1;
        }
        System.out.println(Integer.max(TopDown(input,0),TopDown(input,1)));
        System.out.println(countRecursiveCalls + " recursive calls");
        System.out.println();
        countRecursiveCalls = 0;


        //Naive Approach
        System.out.println(Integer.max(naive(input,0),naive(input,1)));
        System.out.println(countRecursiveCalls + " recursive calls");
        System.out.println();
    }

    private void getInput(){
        Scanner input = new Scanner(System.in);
        String inputData = input.nextLine();
        this.input = new Integer[inputData.split(" ").length];
        this.solvedSubproblems = new Integer[this.input.length+1];

        int i = 0;
        for (String num :inputData.split(" ")) {
            this.input[i] = Integer.parseInt(num);++i;
        }

    }

    private int BottomUp(Integer[] Array){
        solvedSubproblems[0] = 0;
        solvedSubproblems[1] = Array[0];
        int i =0;

        for(i=1;i<Array.length;++i){
            solvedSubproblems[i+1] = Integer.max(Array[i]+solvedSubproblems[i-1],solvedSubproblems[i]);
        }

        return solvedSubproblems[i];
    }

    private int TopDown(Integer[] Array, Integer index){
        ++countRecursiveCalls;
        if(index >= Array.length){
            return 0;
        }

        if(solvedSubproblems[index] == -1){

            solvedSubproblems[index] = Array[index] + Integer.max(TopDown(Array,index+2),TopDown(Array,index+3));
            return  solvedSubproblems[index];
        }
        else{
            return solvedSubproblems[index];
        }
    }

    // This is the naive approach to the solution
    private int naive(Integer []Array, Integer index){
        ++countRecursiveCalls;
        if(index >= Array.length){
            return 0;
        }
        else{
            return Array[index] + Integer.max(naive(Array,index+2),naive(Array,index+3));
        }
    }
}
