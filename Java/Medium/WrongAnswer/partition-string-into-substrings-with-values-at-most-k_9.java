class Solution {
    public int minimumPartition(String s, int k) {
        
        int[] digits = new int[10];
        for (char c : s.toCharArray()) {
            digits[c - '0']++;
        }
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += digits[i] / k + (digits[i] % k == 0 ? 0 : 1);
        }
        return ans;
    }
}