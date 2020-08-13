package com.example.lib;

public class Lianbiao3 {


    public static void main(String[] args) {
        LNode headNode=new LNode();
        LNode preNode=headNode;
        for(int i=1;i<=7;i++){
            LNode node=new LNode();
            node.data=i;
            preNode.next=node;
            preNode=node;
        }

        LianBiao1.printNode(headNode);
    }

    public static void Reverse(LNode head){
        //插入法远离
        //1、从第二个结点开始
        //head 1 2 3 4 5 6 7
        //把遍历到到结点插入到head结点后面
        //head 2 1 3 4 5 6 7
        if(head==null||head.next==null){
            return;
        }

        LNode cur=null;//当前结点
        LNode next=null;
        cur=head.next.next;//2结点
        head.next.next=null;//设置第一个结点链表为尾结点

        while (cur!=null){
            next=cur.next;
            cur.next=head.next;
            head.next=cur;
            cur=next;
        }


    }
}
