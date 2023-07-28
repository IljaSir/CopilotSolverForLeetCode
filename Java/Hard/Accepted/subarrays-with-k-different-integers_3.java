class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    private int atMostK(int[] nums, int k) {
        int res = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}