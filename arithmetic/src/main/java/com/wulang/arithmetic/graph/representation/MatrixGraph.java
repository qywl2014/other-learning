package com.wulang.arithmetic.graph.representation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接矩阵（图太稀疏会浪费空间、时间）
 */
public class MatrixGraph {
    public static void main(String[] args) {
        Node[][] mg = getMatrixGraph();
        print(mg);
    }

    private static Node[][] getMatrixGraph() {
        Node[][] data = new Node[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    data[i][j] = new Node(0,i,j);
                } else {
                    if ((i == 2 && j == 3) || (i == 3 && j == 2)) {
                        data[i][j] = new Node(0,i,j);
                    } else {
                        data[i][j] = new Node(1,i,j);
                    }
                }
            }
        }
        return data;
    }

    private static void dfs(Node[][] data, int a){

    }

    /**
     * 广度优先搜索
     */
    private static void bfs(Node[][] data, int a) {
        int count=0;
        Queue<Node> queue=new LinkedList<>();
        queue.add(data[a][a+1]);
        while(queue.size()>0){
            Node node=queue.poll();
            if(!node.isRead){
                count++;
                node.isRead=true;
                for(int j=node.i+1;j<data.length;j++){
                    Node temp=data[node.i][j];
                    if(!temp.isRead&&temp.data==1){
                        queue.add(temp);
                    }
                }
            }

        }
        System.out.println(count);
    }

    private static void print(Node[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j].data + " ");
            }
            System.out.println();
        }
    }

    private static void minRoad(Node[][] data){

    }

    static class Node {
        int i;
        int j;
        int data;
        boolean isRead;

        Node(int data,int i,int j) {
            this.data = data;
            this.i=i;
            this.j=j;
        }
    }
}
