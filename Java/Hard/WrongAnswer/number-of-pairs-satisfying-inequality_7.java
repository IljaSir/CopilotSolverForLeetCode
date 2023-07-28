class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        long res = 0;
        int n = nums1.length;
        int[] arr = new int[20001];
        for (int i = 0; i < n; i++) {
            arr[nums1[i] - nums2[i] + 10000]++;
        }
        for (int i = 0; i < n; i++) {
            if (diff >= 0) {
                res += arr[nums1[i] - nums2[i] + diff + 10000];
            } else {
                res += arr[nums1[i] - nums2[i] - diff + 10000];
            }
            if (nums1[i] - nums2[i] + diff + 10000 >= 0 && nums1[i] - nums2[i] + diff + 10000 <= 20000) {
                arr[nums1[i] - nums2[i] + diff + 10000]--;
            }
        }
        return res;
    }
}