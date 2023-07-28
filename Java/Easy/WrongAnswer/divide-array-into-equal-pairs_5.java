class Solution {
    public boolean divideArray(int[] nums) {
        
        int n = nums.length;
        if (n % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != 0) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}