class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        int n = nums1.length;
        int[] sum1 = new int[n * n];
        int[] sum2 = new int[n * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1[k] = nums1[i] + nums2[j];
                sum2[k] = nums3[i] + nums4[j];
                k++;
            }
        }
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        int result = 0;
        int i = 0;
        int j = n * n - 1;
        while (i < n * n && j >= 0) {
            int sum = sum1[i] + sum2[j];
            if (sum == 0) {
                int count1 = 1;
                int count2 = 1;
                int x = i + 1;
                while (x < n * n && sum1[x] == sum1[i]) {
                    count1++;
                    x++;
                }
                x = j - 1;
                while (x >= 0 && sum2[x] == sum2[j]) {
                    count2++;
                    x--;
                }
                result += count1 * count2;
                i = x + 1;
                j = x - 1;
            } else if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}