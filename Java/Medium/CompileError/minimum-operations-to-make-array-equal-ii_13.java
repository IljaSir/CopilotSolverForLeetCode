class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        int m = nums2.length;
        int[] diff = new int[n + m];
        int[] cnt = new int[6];
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - 1;
            cnt[nums1[i] - 1]++;
        }
        for (int i = 0; i < m; i++) {
            diff[n + i] = 6 - nums2[i];
            cnt[6 - nums2[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += cnt[i];
        }
        if (sum < k) {
            return -1;
        }
        Arrays.sort(diff);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += diff[i];   for (int l = 0; l <= count1[i - 1] && l <= j; l++) {
                    if (sum[j - l] != Integer.MAX_VALUE) {
                        sum[j] = Math.min(sum[j], sum[j - l] + count2[6 - i] * l);
                    }
                }
            }
        }
        return sum[k];
    }
}