class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        int[] res = new int[nums1.length];
        Arrays.sort(nums1);
        for(int i=0;i<nums2.length;i++){
            int j = binarySearch(nums1,nums2[i]);
            res[i] = nums1[j];
            nums1[j] = -1;
            Arrays.sort(nums1);
        }
        return res;
    }
    public int binarySearch(int[] nums,int target){
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]>target)
                r = mid-1;
            else
                l = mid+1;
        }
        return l;
    }
}