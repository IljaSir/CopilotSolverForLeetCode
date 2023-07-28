class Solution {
    public boolean xorGame(int[] nums) {
        
        int n = nums.length;
        if(n % 2 == 0)
            return true;
        int xor = 0;
        for(int i = 0; i < n; i++)
            xor ^= nums[i];
        return xor == 0;
    }
}