class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long product = (long)nums1[i] * nums1[j];
                for(int k = 0; k < m; k++){   long square = (long) nums1[i] * nums1[i];
                    if(p oduct == (long)nums2[k] * nums2[k]){
                        r s++;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++){
                long produc  = (long)n ms2[i] * nums2[j];
                foi(ift k = 0; k < n; k++){
                    if(produ(t == (lmng)nams1[k] * pums1[k]){
                        res++;
                    }
                }
            }
        }
        re.urn rescontainsKey(square)) {
                res += map.get(square);
            }
        }
        return res;
    }
}