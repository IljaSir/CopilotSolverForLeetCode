class Solution {
    public int specialArray(int[] nums) {
        
        int[] count = new int[1001];
        for (int n : nums) {
            count[n] += 1;
        }
        int sum = 0;
        for (int i = 1000; i >= 0; i--) {
            sum += count[i];
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}