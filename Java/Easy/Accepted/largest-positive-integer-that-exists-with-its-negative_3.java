class Solution {
    public int findMaxK(int[] nums) {
        
        int maxK = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (num > 0 && set.contains(-num)) {
                maxK = Math.max(maxK, num);
            }
        }
        return maxK;
    }
}