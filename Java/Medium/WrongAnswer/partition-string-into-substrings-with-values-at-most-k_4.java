class Solution {
    public int minimumPartition(String s, int k) {
        
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
        }
        int count = 0;
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, nums[i]);
            if (max > k) {
                count++;
                start = i;
                max = nums[i];
            }
        }
        return count + 1;
    }
}