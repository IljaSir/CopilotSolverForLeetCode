class Solution {
    public int countNicePairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int num : nums) {
            int rev = reverse(num);
            int diff = num - rev;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        for (int key : map.keySet()) {
            long val = map.get(key);
            res = (res + val * (val - 1) / 2) % 1000000007;
        }
        return (int) res;
    }

    public int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}