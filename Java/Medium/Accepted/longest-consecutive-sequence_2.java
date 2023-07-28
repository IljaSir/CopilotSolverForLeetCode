class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = 1;
                int next = num + 1;
                while (set.contains(next)) {
                    curr += 1;
                    next += 1;
                }
                longest = Math.max(longest, curr);
            }
        }
        return longest;
    }
}