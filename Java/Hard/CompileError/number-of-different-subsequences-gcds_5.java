class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] sum = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                sum[i] += cnt[j];
            }
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            if (sum[i] > 0) {
                int gcd = i;
                for (int j = i + i; j <= max; j += i) {
                    if (sum[j] > 0) {
                        gcd = gcd(gcd, j);
                    }
                }
                if (gcd == i) {
                    ans++;
                }
            }
        }
        return ans;
    }
}