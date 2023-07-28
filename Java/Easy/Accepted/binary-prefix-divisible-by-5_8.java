class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        int len = nums.length;
        int[] sums = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = (sum * 2 + nums[i]) % 5;
            sums[i] = sum;
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            result.add(sums[i] == 0);
        }
        return result;
    }
}