class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] < k ? -1 : 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < prefix.length; i++) {
            res += map.getOrDefault(prefix[i], 0);
            map.put(prefix[i] + 1, map.getOrDefault(prefix[i] + 1, 0) + 1);
        }
        return res;
    }
}