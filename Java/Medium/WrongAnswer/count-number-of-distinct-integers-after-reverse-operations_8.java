class Solution {
    public int countDistinctIntegers(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            String s = new StringBuilder().append(nums[i]).reverse().toString();
            set.add(Integer.parseInt(s));
        }
        return set.size();
    }
}