class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        int count = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                for(int k = j+1; k < nums2.length; k++){
                    if(nums1[i]*nums1[i] == nums2[j]*nums2[k]){
                        count++;
                    }
                }
            }
        }
        for(int i = 0; i < nums2.length; i++){
            for(int j = 0; j < nums1.length; j++){
                for(int k = j+1; k < nums1.length; k++){
                    if(nums2[i]*nums2[i] == nums1[j]*nums1[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}