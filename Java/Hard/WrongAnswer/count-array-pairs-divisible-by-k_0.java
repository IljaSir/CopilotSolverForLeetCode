class Solution {
    public long countPairs(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.get(num) - 1);
            if (num % k == 0) {
                count += map.getOrDefault(num / k, 0);
            }
            count += map.getOrDefault(k - num % k, 0);
        }
        return count;
    }
}