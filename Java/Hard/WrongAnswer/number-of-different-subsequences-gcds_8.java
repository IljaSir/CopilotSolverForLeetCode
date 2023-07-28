class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int[] count = new int[200001];
        for (int i : nums) {
            count[i]++;
        }
        int ans = 0;
        for (int i = 1; i <= 200000; i++) {
            if (count[i] > 0) {
                ans++;
                for (int j = i + i; j <= 200000; j += i) {
                    count[j] = 0;
                }
            }
        }
        return ans;
    }
}