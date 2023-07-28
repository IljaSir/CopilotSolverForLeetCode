class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        int sum2 = 0;
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }
        int[] arr1 = new int[6];
        int[] arr2 = new int[6];
        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i] - 1]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            arr2[nums2[i] - 1]++;
        }
        int count = 0;
        if (sum1 > sum2) {
            int diff = sum1 - sum2;
            for (int i = 5; i >= 0; i--) {
                if (diff > 0) {
                    if (arr1[i] > arr2[5 - i]) {
                        int t = Math.min(arr1[i] - arr2[5 - i], (diff + i) / (i + 1));
                        diff -= t * (i + 1);
                        count += t;
                    }
                }
            }
        } else {
            int diff = sum2 - sum1;
            for (int i = 5; i >= 0; i--) {
                if (diff > 0) {
                    if (arr2[i] > arr1[5 - i]) {
                        int t = Math.min(arr2[i] - arr1[5 - i], (diff + i) / (i + 1));
                        diff -= t * (i + 1);
                        count += t;
                    }
                }
            }
        }
        return diff > 0 ? -1 : count;
    }
}