class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 < sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempSum = sum1;
            sum1 = sum2;
            sum2 = tempSum;
        }
        int diff = sum1 - sum2;
        int[] count = new int[6];
        for (int i = 0; i < nums1.length; i++) {
            count[nums1[i] - 1]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            count[6 - nums2[i]]++;
        }
        int operations = 0;
        for (int i = 5; i >= 0; i--) {
            if (count[i] == 0) {
                continue;
            }
            int d = (i + 1) * count[i];
            if (d >= diff) {
                return operations + (diff + (i)) / (i + 1);
            }
            diff -= d;
            operations += count[i];
        }
        return -1;
    }
}