class Solution {
    public int countNicePairs(int[] nums) {
        
        int mod = (int)1e9 + 7;
        int[] rev = new int[(int)1e5 + 1];
        for (int i = 1; i < rev.length; i++) {
            rev[i] = reverse(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int r = rev[num - num % 10] + num % 10;
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        int ans = 0;
        for (int cnt : map.values()) {
            ans = (ans + (long)cnt * (cnt - 1) / 2) % mod;
        }
        return ans;
    }
    
    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}