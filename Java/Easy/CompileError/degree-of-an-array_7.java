class Solution {
    public int findShortestSubArray(int[] nums) {
        
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (first.get(nums[i]) == null) first.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, count.get(nums[i]));
        }
        int min = nums.length;
        for (int key : count.keySet()) {
            if (count.get(key) == max)
                min = Math.min(min, i - first.get(key) + 1);
        }
        return min;
    }
}