class Solution {
    public long countPairs(int[] nums, int k) {
        
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = num % k;
            int cnt = map.getOrDefault(key, 0);
            map.put(key, cnt + 1);
        }
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            if (key == 0) {
                ans += (long) cnt * (cnt - 1) / 2;
            } else if (key * 2 == k) {
                ans += (long) cnt * (cnt - 1) / 2;
            } else if (map.containsKey(k - key)) {
                ans += (long) cnt * map.get(k - key);
            }
        }
        return ans;
    }
}