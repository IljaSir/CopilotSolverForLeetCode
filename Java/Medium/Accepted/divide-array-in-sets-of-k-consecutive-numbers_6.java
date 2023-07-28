class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }
            for (int i = 0; i < k; i++) {
                if (map.getOrDefault(num + i, 0) == 0) {
                    return false;
                }
                map.put(num + i, map.get(num + i) - 1);
            }
        }
        return true;
    }
}