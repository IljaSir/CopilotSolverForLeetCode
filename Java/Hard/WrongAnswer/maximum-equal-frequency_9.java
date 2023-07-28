class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int n = nums.length;
        int[] freq = new int[100001];
        int[] count = new int[100001];
        int maxFreq = 0;
        int maxCount = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int f = freq[num];
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
            count[f]--;
            count[freq[num]]++;
            maxCount = Math.max(maxCount, count[freq[num]]);
            if (maxCount * maxFreq == i + 1) {
                res = i + 1;
            } else if (maxCount * maxFreq == i + 2 && count[maxFreq] == 1) {
                res = i + 1;
            }
        }
        return res;
    }
}