class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int[] count = new int[100001];
        int[] freq = new int[100001];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (count[num] > 0) {
                freq[count[num]]--;
            }
            count[num]++;
            freq[count[num]]++;
            if (freq[count[num]] * count[num] == i + 1 && i < nums.length - 1) {
                res = i + 2;
            }
            if (freq[1] == i + 1) {
                res = i + 1;
            }
            if (freq[count[num]] * count[num] == i && freq[1] == 1) {
                res = i + 1;
            }
        }
        return res;
    }
}