package com.e16;

import com.e16.task_018.Pool;

public class Main {
    public static void main(String[] args) {
        Pool pool = new Pool(new int[][] {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });


        System.out.println(pool.maxUnion());


        /*int[][] arr = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(arr[1][2]);*/
    }
}
