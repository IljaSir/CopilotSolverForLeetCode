class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int max = 0;
        for(int i : nums) {
            int count = 1;
            int left = i-1;
            while(set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            int right = i+1;
            while(set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}