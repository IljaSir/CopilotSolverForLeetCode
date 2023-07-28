class Solution {
    public int createSortedArray(int[] instructions) {
        
        int[] nums = new int[100001];
        int cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            int num = instructions[i];
            cost += Math.min(nums[num - 1], i - nums[num]);
            cost %= 1000000007;
            int j = num;
            while (j < 100001) {
                nums[j]++;
                j += j & -j;
            }
        }
        return cost;
    }
}