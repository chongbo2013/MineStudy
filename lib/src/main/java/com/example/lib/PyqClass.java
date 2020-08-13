package com.example.lib;

public class PyqClass {
    public static void main(String[] args) {
        int[][] vvv=new int[3][3];

        int[] vvv1=new int[]{1,1,0};
        int[] vvv2=new int[]{1,1,0};
        int[] vvv3=new int[]{0,0,1};
        vvv[0]=vvv1;
        vvv[1]=vvv2;
        vvv[2]=vvv3;
        int count=findCircleNum(vvv);
        System.out.println("count="+count);
    }

    public static void dfs(int[][] M, int[] visited, int i) {
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1&&visited[j]==0){
                visited[j]=1;
                System.out.println("dfs i="+i+",j="+j+",visited="+getVisiteStr(visited));
                dfs(M,visited,j);

            }else{
                System.out.println("-----dfs i="+i+",j="+j+",visited="+getVisiteStr(visited));
            }
        }
    }
    static  String  getVisiteStr(int[] array){
        return "["+array[0]+","+array[1]+","+array[2]+"]";
    }
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if(visited[i]==0){
                System.out.println("findCircleNum i="+i+",visited="+getVisiteStr(visited));
                dfs(M,visited,i);
                count++;
            }else{
                System.out.println("-----findCircleNum i="+i+",visited="+getVisiteStr(visited));
            }
        }
        return count;
    }
}
