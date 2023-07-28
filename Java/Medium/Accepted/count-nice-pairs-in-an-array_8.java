class Solution {
    public int countNicePairs(int[] nums) {
        
        int mod = (int) 1e9 + 7;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int diff = num - rev(num);
            ans = (ans + map.getOrDefault(diff, 0)) % mod;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return ans;
    }
    
    private int rev(int x) {
        int ans = 0;
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
}