class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int n = nums.length;
        int[] count = new int[2 * n + 1];
        for (int num : nums) {
            if (num < -value) {
                count[0]++;
            } else if (num > value) {
                count[2 * n]++;
            } else {
                count[num + value]++;
            }
        }
        for (int i = 1; i <= 2 * n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i <= 2 * n; i++) {
            if (count[i] == i) {
                return i - value;
            }
        }
        return n + value + 1;
    }
}