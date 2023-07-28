class Solution {
    public int countNicePairs(int[] nums) {
        
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int rev = reverse(n);
            int diff = n - rev;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            res += (long) count * (count - 1) / 2;
        }
        return (int) (res % mod);
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}