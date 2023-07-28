class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        int n = nums.length;
        int m = quantity.length;
        int[] freq = new int[1001];
        for (int num : nums) {
            freq[num]++;
        }
        int[] count = new int[51];
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] > 0) {
                count[freq[i]]++;
            }
        }
        return dfs(count, quantity, 0);
    }
    
    private boolean dfs(int[] count, int[] quantity, int i) {
        if (i == quantity.length) {
            return true;
        }
        for (int j = 1; j < count.length; j++) {
            if (count[j] > 0) {
                count[j]--;
                if (dfs(count, quantity, i + 1)) {
                    return true;
                }
                count[j]++;
            }
        }
        return false;
    }
}