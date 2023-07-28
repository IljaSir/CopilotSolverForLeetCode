class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = getMappedValue(mapping, nums[i]);
        }
        Arrays.sort(res);
        return res;
    }
    
    private int getMappedValue(int[] mapping, int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + mapping[num % 10];
            num /= 10;
        }
        return res;
    }
}