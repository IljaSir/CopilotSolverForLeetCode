class Solution {
    public int countNicePairs(int[] nums) {
        
        int mod = (int)1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int rev = reverse(num);
            int diff = num - rev;
            int cnt = map.getOrDefault(diff, 0);
            ans = (ans + cnt) % mod;
            map.put(diff, cnt + 1);
        }
        return ans;
    }
    
    private int reverse(int num) {
        int ret = 0;
        while (num > 0) {
            ret = ret * 10 + (num % 10);
            num /= 10;
        }
        return ret;
    }
}