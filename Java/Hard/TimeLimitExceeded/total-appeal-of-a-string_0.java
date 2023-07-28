class Solution {
    public long appealSum(String s) {
        
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                ans += set.size();
            }
        }
        return ans;
    }
}