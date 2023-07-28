class Solution {
    public int countDistinctIntegers(int[] nums) {
        
        Set<String> set = new HashSet<>();
        for (int i : nums) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            set.add(sb.toString());
        }
        return set.size();
    }
}