class Solution {
    public int countNicePairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, mod = (int)1e9 + 7;
        for (int num : nums) {
            int rev = reverse(num);
            int diff = num - rev;
            res = (res + map.getOrDefault(diff, 0)) % mod;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return res;
    }
    
    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}