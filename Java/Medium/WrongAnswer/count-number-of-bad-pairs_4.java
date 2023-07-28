class Solution {
    public long countBadPairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            int count = map.getOrDefault(diff, 0);
            ans += count;
            map.put(diff, count + 1);
        }
        return ans;
    }
}