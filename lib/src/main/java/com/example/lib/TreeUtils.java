package com.example.lib;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class TreeUtils {

    public static void main(String[] args) {

//               1
//             2   3
//            4  5  6

        int[] arr=new int[]{1,2,3,4,5,6};
        LNode node=maketree(arr,1);
        System.out.println("\n前");
        printPre(node);
        System.out.println("\n中");
        printmid(node);
        System.out.println("\n后");
        printafter(node);
        System.out.println("\nbfs");
        printbfs(node);
        System.out.println("\ndfs");
        printdfs(node);

        System.out.println("\n 看右边");
        List<Integer> list= rightSideView(node);

        System.out.println("\n 看左边");
        List<Integer> list2= leftSideView(node);

        LNode links=new LNode();
        LNode head=links;
        for(int i=0;i<arr.length;i++){
            LNode temp=new LNode();
            temp.data=arr[i];
            links.next=temp;
            links=temp;
        }
         reverseList(head);

    }

    static LNode maketree(int[] arr,int index){
        if(index>arr.length){
            return null;
        }
        LNode node=new LNode();
        node.data=arr[index-1];
        //l 2i 2
        //r 2i+1  5
        node.left=maketree(arr,2*index);
        node.right=maketree(arr,2*index+1);
        return  node;
    }

    static void printPre(LNode node){
        if(node==null){
            return;
        }
        System.out.print(node.data+",");
        printPre(node.left);
        printPre(node.right);
    }

    static void printmid(LNode node){
        if(node==null){
            return;
        }
        printPre(node.left);
        System.out.print(node.data+",");
        printPre(node.right);
    }
    static void printafter(LNode node){
        if(node==null){
            return;
        }
        printPre(node.left);
        printPre(node.right);
        System.out.print(node.data+",");
    }

    //广度优先遍历是使用队列实现的
    static void printbfs(LNode root){
        if(root==null){
            return;
        }

        Queue<LNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LNode node=queue.poll();

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

            System.out.print(node.data+",");
        }
    }
    //深度优先遍历是使用队列实现的
    static void printdfs(LNode root){
        if(root==null){
            return;
        }

        Stack<LNode> queue=new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LNode node=queue.pop();

            if(node.right!=null){
                queue.add(node.right);
            }
            if(node.left!=null){
                queue.add(node.left);
            }

            System.out.print(node.data+",");
        }
    }

    public static List<Integer> rightSideView(LNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<LNode> queue = new LinkedList<LNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                count--;
                LNode cur = queue.poll();
                if(count == 0){
                    //只有上一层的最后一个才能加入res
                    //如果右面有，就是右面
                    //右面没有，左面就是上一层的最后一个
                    res.add(cur.data);
                }
                //先加左面，先poll左面
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }

    public static List<Integer> leftSideView(LNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<LNode> queue = new LinkedList<LNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            int firts = queue.size()-1;
            while(count > 0){
                count--;
                LNode cur = queue.poll();
                if(count == firts){
                    //只有上一层的最后一个才能加入res
                    //如果右面有，就是右面
                    //右面没有，左面就是上一层的最后一个
                    res.add(cur.data);
                }
                //先加左面，先poll左面
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
    public static LNode reverseList(LNode head) {//4
        if(head==null||head.next==null){
            return head;
        }

        LNode node=reverseList(head.next);//5
        head.next.next=head;
        head.next=null;
        return node;
    }

    public int trap(int[] height) {
        int ans=0;
        for(int i=0;i<height.length;i++){

            int maxLeft=0;
            for(int l=i;l>=0;l--){
                maxLeft=Math.max(height[l],maxLeft);
            }
            int maxRight=0;
            for(int r=i;r<height.length;r++){
                maxRight=Math.max(height[r],maxRight);
            }

            ans+=Math.min(maxLeft,maxRight)-height[i];
        }
        return ans;
    }
}
