class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] shuffled = new int[nums.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n) {
            shuffled[j] = nums[i];
            j += 2;
            i++;
        }
        while (k < n) {
            shuffled[j] = nums[i];
            j += 2;
            i++;
            k++;
        }
        return shuffled;
    }
}