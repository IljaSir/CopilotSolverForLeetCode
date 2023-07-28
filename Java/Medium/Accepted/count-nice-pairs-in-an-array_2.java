class Solution {
    public int countNicePairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            int diff = nums[i] - rev;
            int count = map.getOrDefault(diff, 0);
            res = (res + count) % 1000000007;
            map.put(diff, count + 1);
        }
        return res;
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