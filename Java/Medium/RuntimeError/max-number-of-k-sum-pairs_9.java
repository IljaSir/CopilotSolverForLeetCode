class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int[] map = new int[1000001];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map[k - nums[i]] > 0) {
                map[k - nums[i]]--;
                count++;
            } else {
                map[nums[i]]++;
            }
        }
        return count;
    }
}