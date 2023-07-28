class Solution {
    public int longestSquareStreak(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            int len = 1;
            int prev = num;
            while (set.contains(prev - 1)) {
                prev--;
                len++;
            }
            max = Math.max(max, len);
        }
        return max == 1 ? -1 : max;
    }
}