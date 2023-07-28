class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private int atMostK(int[] nums, int k) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            if (count.getOrDefault(nums[j], 0) == 0) {
                k--;
            }
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            while (k < 0) {
                count.put(nums[i], count.get(nums[i]) - 1);
                if (count.get(nums[i]) == 0) {
                    k++;
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}