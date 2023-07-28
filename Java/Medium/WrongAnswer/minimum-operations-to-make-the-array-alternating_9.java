class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int[] op = new int[2];
        for (int i = 0; i < n; i++) {
            op[i % 2] += (nums[i] % 2 != i % 2 ? 1 : 0);
            op[(i + 1) % 2] += (nums[i] % 2 == (i + 1) % 2 ? 1 : 0);
        }
        return Math.min(op[0], op[1]);
    }
}