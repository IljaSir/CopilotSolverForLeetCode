class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                res[0] = i;
                res[1] = map.get(target - x);
                return res;
            }
            map.put(x, i);
        }
        return res;
    }
}