class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int[] count = new int[100001];
        int[] freq = new int[100001];
        int res = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            max = Math.max(max, ++count[num]);
            freq[count[num]]++;
            if (freq[max] * max == i + 1 && i < nums.length - 1) res = i + 2;
            else if (freq[max] * max == i && freq[max - 1] == 1) res = i + 1;
        }
        return res;
    }
}