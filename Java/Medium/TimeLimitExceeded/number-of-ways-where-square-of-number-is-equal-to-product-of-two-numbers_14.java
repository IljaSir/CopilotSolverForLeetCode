class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long product = (long)nums1[i] * nums1[j];
                for(int k = 0; k < m; k++){
                    if(product == (long)nums2[k] * nums2[k]){
                        res++;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++){
                long product = (long)nums2[i] * nums2[j];
                for(int k = 0; k < n; k++){
                    if(product == (long)nums1[k] * nums1[k]){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}