class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[10001];
        for (int x: nums) {
            count[x]++;
            if (count[x] > 1)
                return x;
        }
        return -1;
    }
}