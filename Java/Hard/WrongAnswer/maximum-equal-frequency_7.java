class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int[] freq = new int[100001];
        int[] count = new int[100001];
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count[freq[num]]--;
            freq[num]++;
            count[freq[num]]++;
            if (freq[num] * count[freq[num]] == i + 1) {
                max = freq[num];
            }
            if (count[max] == 1 && max * count[max] == i + 1) {
                res = i + 1;
            } else if (count[1] == i + 1) {
                res = i + 1;
            }
        }
        return res;
    }
}