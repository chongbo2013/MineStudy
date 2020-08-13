package com.example.lib;

import java.util.HashSet;
import java.util.Set;

public class SearchUtils {
    public static void main(String[] args) {
        int [] list=new int[]{4,2,3,1,6,5};
        int value= binarysearch(list,3);
        System.out.print(value);


    }



    //二分法查找
    public static int binarysearch(int[] list,int search){
         fastSort(list,0,list.length-1);//o(nlogn)
         return search2(list,search,0,list.length-1);
    }

    public static  int search(int[] list,int search,int low,int height){
        if(low>height){
            return -1;
        }

        int mid=low+(height-low)/2;
        if(search<list[mid]){//前半部
            return search(list,search,low,mid-1);
        }else if(search>list[mid]){
            return  search(list,search,mid+1,height);
        }else{
            return  mid;
        }

    }

    //插值查找
    public static  int search2(int[] list,int search,int low,int height){
        if(low>height){
            return -1;
        }

        int mid=low+(search-low)*((search-list[low])/(list[height]-list[low]));
        if(search<list[mid]){//前半部
            return search2(list,search,low,mid-1);
        }else if(search>list[mid]){
            return  search2(list,search,mid+1,height);
        }else{
            return  mid;
        }

    }

   //快排
    public static void fastSort(int[] arrays,int low,int height){
        //一定义base 比base大放右边，小大放左边
        if(low>=height){
            return;
        }
        int l=low;
        int r=height;
        int base=low;

        while (l<r){

            if(l<r&&arrays[l]<arrays[base]){
                l++;
            }
            if(l<r&&arrays[r]>arrays[base]){
                r--;
            }

            if(l<r){
                //交换
                swap(arrays,l,r);
            }

        }
        //l==i
        //交换base i
        swap(arrays,base,l);

        //递归左边和右边
        fastSort(arrays,low,l-1);
        fastSort(arrays,l+1,height);

    }
    public static void swap(int[] arrays,int i,int j){
//        arrays[i]=arrays[i]+arrays[j];
//        arrays[j]=arrays[i]-arrays[j];
//        arrays[i]=arrays[i]-arrays[j];
        int temp=arrays[i];
        arrays[i]=arrays[j];
        arrays[j]=temp;
    }
}
