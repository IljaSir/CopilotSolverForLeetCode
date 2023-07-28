class Solution {
    public int specialArray(int[] nums) {
        
        int[] count = new int[1001];
        for (int n : nums) {
            count[n]++;
        }
        int x = nums.length;
        for (int i = 1000; i >= 0; i--) {
            if (count[i] >= x) {
                if (x == 0 || count[i - 1] < x) {
                    return x;
                }
            }
            x -= count[i];
        }
        return -1;
    }
}