package com.example.lib;

public class LianBiao1 {
    public static void main(String[] args) {

        LNode head=new LNode();
        LNode next=null;
        for(int i=1;i<=7;i++){
            LNode cur=new LNode();
            cur.data=i;
            if(head.next==null){
                head.next=cur;
                next=cur;
            }else {
                next.next=cur;
                next=cur;
            }
        }
        next.next=null;
        Reverse(head);

        printNode(head);
    }

    public static void printNode(LNode head){
        StringBuffer buffer=new StringBuffer();
        LNode cur=head.next;
        while (head!=null){
            buffer.append(" "+cur.data);
            cur=cur.next;
        }
        System.out.println(buffer.toString()+"\n");
    }

    public static void Reverse(LNode head){
    //head-> 1 ->2 ->3 -> 4 ->5 -> 6 ->7

        // head-> 7 ->6-> 5 -> 4 ->3 -> 2 ->1

        if(head==null||head.next==null){
            return;
        }

        //把首结点指向尾结点
        LNode pre,cur,next;
        cur=head.next;//1
        next=cur.next;//2
        cur.next=null;

        pre=cur;//1
        cur=next;//2
        //当前结点2
        while (cur!=null){//7
            next=cur.next;//空
            cur.next=pre;//6

            if(next==null)
                break;
            pre = cur;//2
            cur = next;//3

        }

        head.next=cur;
    }
}
