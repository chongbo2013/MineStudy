package com.example.lib;

public class MyClass {

    public static LNode rsNode(LNode head){//4
        //1 2 3 4 5
        //5 4 3 2 1
        if(head==null||head.next==null){
            return head;
        }

        LNode newNode=rsNode(head.next);//5
        head.next.next=head;
        head.next=null;
        return newNode;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,3,5};
        minArray(array);
    }
    public static int minArray(int[] numbers) {
        int min=numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<min){
                min=Math.min(numbers[i],min);
                return min;
            }else{
                min=Math.min(numbers[i],min);
            }
        }
        return 0;
    }
}
