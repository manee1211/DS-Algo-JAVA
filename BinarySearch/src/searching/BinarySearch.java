package searching;

public class BinarySearch {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,5,6,7,8,9,10};
        int target = 5;
        int index = find(nums,target);
        if(index!=-1){
            System.out.println("Found at index: "+index);
        }else{
            System.out.println("Not Found");
        }
        int insertIndex = insertIndex(nums,target);
        System.out.println("Insert at index: "+insertIndex);
        int upperBound = upperBound(nums,target);
        System.out.println("Upper Bound: "+upperBound);
        int lowerBound = lowerBound(nums,target);
        System.out.println("Lower Bound: "+lowerBound);
    }

    public static int find(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
    public static int insertIndex(int[] nums,int target){
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=target){
                r= mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public static int upperBound(int[] nums,int target){
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>target){
                r= mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public static int lowerBound(int[] nums,int target){
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=target){
                r= mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
