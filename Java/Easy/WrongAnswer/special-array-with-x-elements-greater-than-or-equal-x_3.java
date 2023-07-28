class Solution {
    public int specialArray(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = n; i >= 0; i--) {
            if (i < 1000) {
                count[i] += count[i + 1];
            }
            if (count[i] == i) {
                return i;
            }
        }
        return -1;
    }
}