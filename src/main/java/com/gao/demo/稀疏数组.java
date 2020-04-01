package com.gao.demo;

/**
 * @version 1.0
 * @class: 稀疏数组
 * @author: 高林芳
 * @mail: 309280754@qq.com
 * @date: 2020/3/31 17:30
 * @description: 稀疏数组
 */
public class 稀疏数组 {

    public static void main(String[] args) {

        // 创建一个新数组
        int[][] array = new int[6][8];
        array[2][3] = 1;
        array[5][2] = 9;
        array[3][1] = 8;
        soutArray(array);
        soutArray(zipArray(array));
        soutArray(unzipArray(zipArray(array)));
    }





    //压缩稀疏数组
    private static int[][] zipArray(int[][] array){
        // 数据量
        int sum = 0;
        for(int[] row : array){
            for (int data: row){
                if(data > 0){
                    sum++;
                }
            }
        }

        int[][] sparArray = new int[sum + 1][3];
        // 稀疏数组的第一行
        sparArray[0][0] = array.length;  // 原数组row
        sparArray[0][1] = array[0].length; // 原数组line
        sparArray[0][2] = sum;  // 原数组里有效数据数量

        int count = 1;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if(array[i][j] != 0){
                    sparArray[count][0] = i;
                    sparArray[count][1] = j;
                    sparArray[count][2] = array[i][j];
                    count++;
                }
            }
        }

        return sparArray;

    }


    //还原稀疏数组
    private static int[][] unzipArray(int[][] array){
        // 还原原来的数组
        int row = array[0][0];
        int line = array[0][1];
        int[][] unzipArr = new int[row][line];

        for (int i = 1; i <= array[0][2]; i++){
            unzipArr[array[i][0]][array[i][1]] = array[i][2];
        }
        return unzipArr;
    }

    /**
     * 打印二维数组
     * @param array
     */
    private static void soutArray(int[][] array) {
        for(int[] row : array){
            for (int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

}
