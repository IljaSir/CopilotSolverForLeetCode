class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        int n=nums1.length;
        int[] swap=new int[n];
        int[] noswap=new int[n];
        swap[0]=1;
        noswap[0]=0;
        for(int i=1;i<n;i++){
            swap[i]=Integer.MAX_VALUE;
            noswap[i]=Integer.MAX_VALUE;
            if(nums1[i-1]<nums1[i] && nums2[i-1]<nums2[i]){
                swap[i]=swap[i-1]+1;
                noswap[i]=noswap[i-1];
            }
            if(nums1[i-1]<nums2[i] && nums2[i-1]<nums1[i]){
                swap[i]=Math.min(swap[i],noswap[i-1]+1);
                noswap[i]=Math.min(noswap[i],swap[i-1]);
            }
        }
        return Math.min(swap[n-1],noswap[n-1]);
    }
}