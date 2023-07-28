class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(k - num)) {
                int count = map.get(k - num);
                if (count == 1) {
                    map.remove(k - num);
                } else {
                    map.put(k - num, count - 1);
                }
                ans++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }
}