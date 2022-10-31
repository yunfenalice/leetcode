package org.example.sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] nums={2,1,3,4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static int[] temp;
    public static void sort(int[] nums){
        temp=new int[nums.length];//now the temp is empty
        sort(nums,0,nums.length-1);

    }
     static void sort(int[] nums,int lo,int hi){//[lo,hi]
        if(lo==hi) return;
        int mid=lo+(hi-lo)/2;
        sort(nums,0,mid);
        sort(nums,mid+1,hi);
         merge(nums,lo,mid,hi);
    }
    private static void merge(int[] nums,int lo, int mid, int hi){
        for (int i = lo; i <=hi; i++) {
            temp[i]=nums[i];
        }
        //array two pointer merge two sorted array
        int p1=lo;
        int p2=mid+1;
        for(int p=lo;p<=hi;p++){
            if(p1==mid+1){
                nums[p]=temp[p2++];
            }else if(p2==hi+1){ //right array has already fully merged.
                nums[p]=temp[p1++];
            }else if(temp[p1]>temp[p2]){
                nums[p]=temp[p2++];
            }else{
                nums[p]=temp[p1++];
            }
        }

    }




}
