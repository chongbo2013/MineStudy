package com.example.lib;

import javax.xml.soap.Node;

//链表逆序 递归法
public class LianBIao2 {

    public static void main(String[] args) {



        LNode headNode=new LNode();
        LNode preNode=headNode;
        for(int i=1;i<=7;i++){
            LNode node=new LNode();
            node.data=i;
            preNode.next=node;
            preNode=node;
        }








       recursionNode(headNode);

    }

    public static LNode recursionNode(LNode head){//6

            //递归逆序链表
        // 1 2 3 4 5 6 7
        // 7 6 5 4 3 2 1

        //先逆序除第一个结点外到其他点
        //再把第一个添加末尾
       if(head==null||head.next==null){
           return head;
       }

       //head 6
        LNode newNode=recursionNode(head.next);//7
        head.next.next=head;// 7指向6 交换
        head.next=null; //6为尾结点
        return  newNode;

    }

}
