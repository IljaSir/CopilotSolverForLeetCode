class Solution {
    public int countNicePairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            int diff = nums[i] - rev;
            int count = map.getOrDefault(diff, 0);
            result = (result + count) % 1000000007;
            map.put(diff, count + 1);
        }
        return result;
    }
    
    private int reverse(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result;
    }
}