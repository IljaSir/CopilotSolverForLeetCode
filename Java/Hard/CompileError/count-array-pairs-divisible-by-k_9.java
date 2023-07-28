class Solution {
    public long countPairs(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int num : nums) {
            if (k == 0) {
                res += map.getOrDefault(num, 0);
            } else {
                int mod = num % k;
                int need = (k - mod) % k;
                res += map.getOrDefault(need, 0);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }
}