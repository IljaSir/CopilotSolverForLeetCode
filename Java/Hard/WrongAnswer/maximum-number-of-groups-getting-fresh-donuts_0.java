class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int[] count = new int[batchSize];
        int ans = 0;
        for (int g : groups) {
            if (g % batchSize == 0) {
                ans++;
            } else {
                count[g % batchSize]++;
            }
        }
        int max = 0;
        for (int i = 1; i < batchSize; i++) {
            max = Math.max(max, Math.min(count[i], count[batchSize - i]));
        }
        ans += max;
        if (count[0] > 0) {
            ans++;
        }
        return ans;
    }
}