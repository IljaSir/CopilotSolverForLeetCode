class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int res = 0, mod = 1000000007;
        for (int i = 1; i < count.length; i++) {
            int sum = 0;
            for (int j = i; j < count.length; j += i) {
                sum += count[Math.min(j + i - 1, count.length - 1)] - count[j - 1];
                res = (res + sum * (j / i)) % mod;
            }
        }
        return res;
    }
}