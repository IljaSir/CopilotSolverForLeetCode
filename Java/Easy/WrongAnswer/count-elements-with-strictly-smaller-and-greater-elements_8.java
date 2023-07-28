class Solution {
    public int countElements(int[] nums) {
        
        int[] count = new int[200_001];
        for (int n : nums) {
            count[n + 100_000]++;
        }
        int res = 0;
        for (int i = 1; i < count.length - 1; i++) {
            if (count[i - 1] > 0 && count[i + 1] > 0) {
                res += count[i];
            }
        }
        return res;
    }
}