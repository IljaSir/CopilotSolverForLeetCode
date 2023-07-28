class Solution {
    public int findMaxK(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i: nums) {
            set.add(i);
            if(i > 0) max = Math.max(max, i);
        }
        for(int i = max; i > 0; i--) {
            if(set.contains(i) && set.contains(-i)) return i;
        }
        return -1;
    }
}