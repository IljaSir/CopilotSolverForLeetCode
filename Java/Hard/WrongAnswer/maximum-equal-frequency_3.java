class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int[] count = new int[100001];
        int[] freq = new int[100001];
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int c = count[num];
            if (c > 0) {
                freq[c]--;
            }
            count[num]++;
            freq[c + 1]++;
            if (freq[c + 1] * (c + 1) == i + 1) {
                max = i + 1;
            }
            if (c > 0 && freq[c] * c == i) {
                res = i;
            }
            if (freq[1] == i + 1) {
                res = i + 1;
            }
        }
        return Math.max(max, res);
    }
}