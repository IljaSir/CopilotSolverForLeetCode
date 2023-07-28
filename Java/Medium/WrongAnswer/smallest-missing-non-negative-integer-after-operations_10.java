class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int n = nums.length;
        int i = 0;
        while (i < n && sorted[i] < value) {
            value -= sorted[i];
            i++;
        }
        return i + value;
    }
}