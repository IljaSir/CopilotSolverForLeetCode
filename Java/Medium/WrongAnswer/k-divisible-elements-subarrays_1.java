class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int x = prefix[i] % p;
            if (i - k - 1 >= 0) {
                int y = prefix[i - k - 1] % p;
                count.put(y, count.getOrDefault(y, 0) - 1);
                if (count.get(y) == 0) {
                    count.remove(y);
                }
            }
            res += count.getOrDefault(x, 0);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        return res;
    }
}