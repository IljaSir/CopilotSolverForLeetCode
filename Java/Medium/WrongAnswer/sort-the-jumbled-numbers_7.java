class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sorted[i] = mapNum(nums[i], mapping);
        }
        Arrays.sort(sorted);
        return sorted;
    }
    
    private int mapNum(int num, int[] mapping) {
        int mapped = 0;
        int count = 0;
        while(num > 0) {
            int digit = num % 10;
            num /= 10;
            mapped += (int) Math.pow(10, count) * mapping[digit];
            count++;
        }
        return mapped;
    }
}