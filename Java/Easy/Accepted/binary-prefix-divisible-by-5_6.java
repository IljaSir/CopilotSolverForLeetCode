class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        int n = nums.length;
        List<Boolean> ans = new ArrayList<Boolean>(n);
        int x = 0;
        for (int i = 0; i < n; i++) {
            x = ((x << 1) + nums[i]) % 5;
            ans.add(x == 0);
        }
        return ans;
    }
}