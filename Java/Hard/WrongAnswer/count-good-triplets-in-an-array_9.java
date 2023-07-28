class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        
        long count = 0;
        int n = nums1.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums1[i]<nums1[j] && nums1[j]<nums1[k]){
                        if(nums2[i]<nums2[j] && nums2[j]<nums2[k]){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}