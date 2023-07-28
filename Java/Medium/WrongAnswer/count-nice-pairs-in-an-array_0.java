class Solution {
    public int countNicePairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int rev = reverse(num);
            int diff = num - rev;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            res = (res + cnt * (cnt - 1) / 2) % 1000000007;
        }
        return res;
    }
    private int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}