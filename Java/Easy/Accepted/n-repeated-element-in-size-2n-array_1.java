class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == n) {
                return num;
            }
        }
        return -1;
    }
}