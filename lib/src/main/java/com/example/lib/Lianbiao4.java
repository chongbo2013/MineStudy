package com.example.lib;

public class Lianbiao4 {

    //如何从无序链表中移除重复项目
    public static void main(String[] args) {
        LNode headNode=new LNode();
        headNode.next=null;
        LNode temp=null;
        LNode cur=headNode;

        for(int i=1;i<=7;i++){
            temp=new LNode();
            if(i%2==0){
                temp.data=i+1;
            }else if(i%3==0){
                temp.data=i-2;
            }else{
                temp.data=i;
            }

           temp.next=null;
            cur.next=temp;
            cur=temp;
        }

        LianBiao1.printNode(headNode);
    }

    public static void Reverse(LNode head){
   //如何从无序链表中移除重复项目
        //head 1 1 3 4
//                 1 3 4
        if(head==null||head.next==null){
            return;
        }

      LNode outerCur=head.next;
      LNode innerCur=null;
      LNode innerPre=null;
       for(;outerCur!=null;outerCur=outerCur.next){
           for(innerCur=outerCur.next,innerPre=outerCur;innerCur!=null;){
               if(outerCur.data==innerCur.data){
                   innerPre.next=innerCur.next;
                   innerCur=innerCur.next;
               }else{
                   innerPre=innerCur;
                   innerCur=innerCur.next;
               }
           }
       }

    }
}
