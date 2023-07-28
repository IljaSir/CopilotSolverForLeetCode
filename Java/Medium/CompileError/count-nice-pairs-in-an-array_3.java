class Solution {
    public int countNicePairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, mod = 1000000007;
        for (int num : nums) {
            int diff = num - reverse(num);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        for (int count : map.values()) {
            res = (res + (long) count * (count - 1) / 2) % mod;
        }
        return res;
    }
    
    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
}