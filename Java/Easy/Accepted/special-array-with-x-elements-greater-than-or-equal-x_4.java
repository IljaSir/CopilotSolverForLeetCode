class Solution {
    public int specialArray(int[] nums) {
        
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int sum = nums.length;
        for (int i = 0; i <= 1000; i++) {
            if (sum == i) {
                return i;
            }
            sum -= count[i];
        }
        return -1;
    }
}