class Solution {
    public int countDistinctIntegers(int[] nums) {
        
        Set<String> set = new HashSet<>();
        for (int num : nums) {
            set.add(new StringBuilder(String.valueOf(num)).reverse().toString());
        }
        return set.size();
    }
}