class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int[] count = new int[100001];
        int[] freq = new int[100001];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int c = count[num];
            count[num]++;
            freq[c]--;
            freq[c + 1]++;
            if (freq[c] == 0 && c + 1 != max) {
                if (c == max - 1 && freq[c + 1] == 1) {
                    max = c + 1;
                } else if (c == 1) {
                    max = c;
                }
            }
        }
        return max;
    }
}