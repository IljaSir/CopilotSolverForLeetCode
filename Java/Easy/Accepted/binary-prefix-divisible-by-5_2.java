class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum * 2 + nums[i]) % 5;
            result.add(sum == 0);
        }
        return result;
    }
}