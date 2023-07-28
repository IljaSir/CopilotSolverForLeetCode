class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int res = 0;
        int i = 0;
        int j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}