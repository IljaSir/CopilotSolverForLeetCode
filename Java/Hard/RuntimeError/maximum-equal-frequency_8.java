class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int[] count = new int[100001];
        int[] freq = new int[100001];
        int result = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int c = count[num];
            if (c > 0) {
                freq[c]--;
                if (freq[c] == 0 && c == max) {
                    max--;
                }
            }
            count[num]++;
            freq[count[num]]++;
            if (freq[count[num]] == count[num]) {
                max = Math.max(max, count[num]);
            }
            if (max * freq[max] == i) {
                result = i + 1;
            } else if ((max - 1) * freq[max - 1] == i) {
                result = i + 1;
            }
        }
        return result;
    }
}