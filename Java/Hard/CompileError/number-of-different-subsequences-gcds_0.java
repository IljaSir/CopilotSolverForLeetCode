class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] seen = new boolean[max + 1];
        for (int num : nums) {
            seen[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int gcd = 0;
            for (int j = i; j <= max; j += i) {
                if (seen[j]) {
                    gcd = gcd(gcd, j);
                }
            }
            if (gcd == i) {
                ans++;
            }
        }
        return ans;
    }
}