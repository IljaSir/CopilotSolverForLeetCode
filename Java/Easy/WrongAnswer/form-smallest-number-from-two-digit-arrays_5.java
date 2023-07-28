class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int ans = 0;
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                ans = ans*10 + nums1[i];
                i++;
            } else {
                ans = ans*10 + nums2[j];
                j++;
            }
        }
        while(i < nums1.length) {
            ans = ans*10 + nums1[i];
            i++;
        }
        while(j < nums2.length) {
            ans = ans*10 + nums2[j];
            j++;
        }
        return ans;
    }
}