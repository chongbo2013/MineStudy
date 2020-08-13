package com.example.lib;

import java.util.List;

public class SortUtils {
    public static void main(String[] args) {
        int [] list=new int[]{4,2,3,1,6,5};
        //冒泡排序 o(n2) o(1)
        System.out.println("冒泡排序：");
        maopaoSort(list);
        printList(list);
        //插入排序 o(n2) o(1)
        System.out.println("插入排序：");
        insertSort(list);
        printList(list);

        //希尔排序 o(nlogn) o(1)
        System.out.println("希尔排序：");
        shellSort(list);
        printList(list);
        //归并排序 o(nlogn) o(n)
        System.out.println("归并排序：");
        guibinSort(list);
        printList(list);


        //选择排序 不稳定 o(n2) o(1)
        System.out.println("选择排序：");
        selectSort(list);
        printList(list);


        //快速排序 不稳定 o(nlogn) o(1)
        System.out.println("快速排序：");
        fastSort(list,0,list.length-1);
        printList(list);

        //堆排序 不稳定 o(nlogn) o(1)
        System.out.println("堆排序：");
        treeSort(list);
        printList(list);
    }


    public static void treeSort(int[] arrays){
        for(int i=0;i<arrays.length;i++){

            //建立堆,每次建堆后，少掉堆尾堆几个
            maxHeap(arrays,arrays.length-i);

            //交换 堆投和堆尾
            int temp=arrays[0];
            arrays[0]=arrays[arrays.length-i-1];
            arrays[arrays.length-i-1]=temp;
        }
    }

    public static void maxHeap(int[] arrays,int size){
        //从最后一个节点开始到0节点，建堆
        for(int i=size-1;i>=0;i--){
            heapbuild(arrays,i,size);
        }

    }
    public static  void heapbuild(int[] arrays,int curNode,int size){
        if(curNode>=size){
            return;
        }
        int max=curNode;

        int left=2*curNode+1;
        int right=2*curNode+2;

        if(left<size){
            if(arrays[left]>arrays[max]) {
                max = left;
            }
        }
        if(right<size){
           if(arrays[right]>arrays[max]){
               max=right;
           }
        }


        //交换  max和 curNode
        if(max!=curNode) {
            swap(arrays, max, curNode);
            //继续递归
            heapbuild(arrays,max,size);
        }


    }

    public static  void fastSort(int[] arr,int low ,int height){
        if(low>height){
            return;
        }
        int l=low;
        int r=height;
        int base=low;
        while (l<r){
            //l找比 base 大的数
            //r找比 base 小的数
            //找到后交换
            while (arr[l]<arr[base]&&l<r){
                l++;
            }
            while ((arr[r]>arr[base])&&l<r){
                r--;
            }

            if(l<r){
                //交换
                swap(arr,l,r);
            }

        }

        //基准和i,j相等位置交换
        swap(arr,base,l);

        fastSort(arr,low,l-1);
        fastSort(arr,l+1,r);
    }

    public static  void selectSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){//交换
                    min=j;
                }
            }
            if(i!=min) {
                swap(arr, i, min);
            }

        }


    }

    public static  void guibinSort(int[] arr){

        guibinDg(arr,0,arr.length-1);

    }
    public static  int[] guibinDg(int[] arr,int low,int height){
        int mid=low+(height-low)/2;
        //0 5   0+ 2
        if(low<height){
            guibinDg(arr,low,mid);
            guibinDg(arr,mid+1,height);
            guibinMerge(arr,low,mid,height);
        }

        return  arr;
    }
    public static void guibinMerge(int [] arr,int low,int mid,int height){
        //存放对比值
       int[] temp=new int[height-low+1];
       int k=0;
       int i=low;
       int j=mid+1;
       while (i<=mid&&j<=height){
           if(arr[i]<=arr[j]){
               temp[k++]=arr[i++];
           }else{
               temp[k++]=arr[j++];
           }

       }

       while (i<=mid){
           temp[k++]=arr[i++];
       }

        while (j<=height){
            temp[k++]=arr[j++];
        }
        //替换
        for(int x=0;x<temp.length;x++){
            arr[low+x]=temp[x];
        }

    }


    public  static void shellSort(int[] arr) {
        //step:步长
        //分组，插入排序
        for(int step=arr.length/2;step>0;step/=2){

            for(int i=step;i<arr.length;i++){
                int temp=arr[i];
                int j;
                for(j=i-step;j>=0&&arr[j]>arr[i];j-=step){
                    //交换
                    arr[j+step]=arr[j];
                }
                arr[j+step]=temp;

            }


        }
    }


    //插入排序
    public  static void insertSort(int[] list){
      for(int i=1;i<list.length;i++){
          for(int j=i;j>0;j--){
              if(list[j]<list[j-1]){
                  swap(list,j,j-1);
              }
          }
      }
    }

    //冒泡排序
    public  static void maopaoSort(int[] list){
        for(int i=0;i<list.length-1;i++){
            for(int j=0;j<list.length-i-1;j++){
                if(list[j]>list[j+1]){
                    swap(list,j,j+1);
                }
            }
        }
    }
    public  static void swap(int[] list,int i,int j){
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
    }



    public  static void printList(int[] list){
        StringBuilder builder=new StringBuilder();
      for(int i=0;i<list.length;i++){
          builder.append(list[i]+",");
      }
      System.out.println(builder.toString());
    }
}
