class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int[] count = new int[1 << 17];
        count[0] = 1;
        for (int num : nums) {
            int[] newCount = new int[1 << 17];
            for (int i = 0; i < 1 << 17; i++) {
                newCount[i | num] += count[i];
            }
            count = newCount;
        }
        int max = 0;
        for (int i = 0; i < 1 << 17; i++) {
            max = Math.max(max, i);
        }
        return count[max];
    }
}