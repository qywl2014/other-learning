package com.wulang.arithmetic.graph.representation;

/**
 * 图 G(v,e)由顶点和边组成，分为有向图和无向图
 * 图的表示：
 *      邻接矩阵，G[i][j],i、j表示顶点编号，数组的值0和1表示是否有边，
 *          无向图可以用一维数组节省一般的空间，但找边麻烦了，要通过计算
 *      邻接表
 */
public interface Graph {
    /**
     * 深度优先搜索
     *      原路返回
     *      类似树的先序遍历
     *      void dfs(Vertex v){
     *          visited[v] = true;//标记v访问过
     *          for(v的每个邻接点 w){
     *              if(!visited[w]){//w未访问过则递归继续，否则换一个邻接点，最后返回v
     *                  dfs(w);
     *              }
     *          }
     *      }
     */
    void dfs();

    /**
     * 广度优先搜索
     *      借助队列
     *      类似树的层序便利
     *      void bfs(Vertex v){
     *
     *      }
     */
    void bfs();
}
